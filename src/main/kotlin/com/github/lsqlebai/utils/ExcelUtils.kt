package com.github.lsqlebai.utils

import com.github.lsqlebai.annotation.ExcelFieldName
import com.github.lsqlebai.annotation.ReflectHelper
import org.apache.poi.hssf.usermodel.*
import org.apache.poi.ss.usermodel.CellType
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.lang.reflect.Field
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by lsq on 2017/9/16.
 */
object ExcelUtils {
    //获取id与java bean field的关系
    fun getBeanFieldMap(sheet: HSSFSheet, cls: Class<*>): Map<Int, String> {
        val ret = HashMap<Int, String>()

        val row = sheet.getRow(0)
        val colNum = row.physicalNumberOfCells


        val excelFieldNameMap = getObjectExcelFieldNameMap(cls)
        for (i in 0 until colNum) {
            val title = getCellFormatValue(row.getCell(i.toShort().toInt()))
            if (excelFieldNameMap.containsKey(title)) {
                ret.put(i, excelFieldNameMap[title]!!)
            }
        }
        return ret
    }

    class OneToOneExcelItem(internal var key: String, internal var value: String)

    fun writeListByColumn(list: List<OneToOneExcelItem>, hssfRow: HSSFRow, column: Int) {
        var column = column
        for (item in list) {
            var cell = hssfRow.createCell(column)
            cell.setCellValue(item.key)
            column++
            cell = hssfRow.createCell(column)
            cell.setCellValue(item.value)
            column++
        }
    }

    //获取id与java bean field的关系
    @JvmOverloads
    fun getOutputFieldMap(sheet: HSSFSheet, cls: Class<*>, titleRow: Int = 0): Map<Int, Field> {
        val ret = HashMap<Int, Field>()

        val row = sheet.getRow(titleRow)
        val colNum = row.physicalNumberOfCells


        val excelFieldNameMap = getObjectExcelFieldMap(cls)
        for (i in 0 until colNum) {
            val title = getCellFormatValue(row.getCell(i.toShort().toInt()))
            if (excelFieldNameMap.containsKey(title)) {
                ret.put(i, excelFieldNameMap[title]!!)
            }
        }
        return ret
    }

    fun <T> getBeanFromSheet(sheet: HSSFSheet, fieldMap: Map<Int, String>, cls: Class<T>, rowNum: Int): T {

        val row = sheet.getRow(rowNum)
        val colNum = row.physicalNumberOfCells
        val map = HashMap<String, String>()
        for (i in 0 until colNum) {
            val value = getCellFormatValue(row.getCell(i))
            val fieldName = fieldMap[i]
            if (fieldName != null) {
                map.put(fieldName, value.trim())
            }
        }
        return JsonUtils.str2Obj(JsonUtils.obj2Str(map), cls)
    }


    fun <T> parseSheetToList(sheet: HSSFSheet, cls: Class<T>): List<T> {
        val fieldMap = getBeanFieldMap(sheet, cls)
        return getBeanListFromSheet(sheet, fieldMap, cls, 1, sheet.lastRowNum)
    }

    fun <T> getBeanListFromSheet(sheet: HSSFSheet, fieldMap: Map<Int, String>, cls: Class<T>, startRow: Int, endRow: Int): List<T> {
        val ret = ArrayList<T>()
        for (i in startRow..endRow) {
            ret.add(getBeanFromSheet(sheet, fieldMap, cls, i))
        }
        return ret
    }

    private fun getObjectExcelFieldNameMap(cls: Class<*>): Map<String, String> {
        val ret = HashMap<String, String>()
        val fieldMap = ReflectHelper.getFields(cls)
        for ((key, value) in fieldMap) {
            val excelFieldName = value.getAnnotation(ExcelFieldName::class.java)
            if (excelFieldName != null) {
                ret.put(excelFieldName.value, key)
                continue
            }
        }
        return ret
    }

    private fun getObjectExcelFieldMap(cls: Class<*>): Map<String, Field> {
        val ret = HashMap<String, Field>()
        val fieldMap = ReflectHelper.getFields(cls)
        for ((_, value) in fieldMap) {
            val excelFieldName = value.getAnnotation(ExcelFieldName::class.java)
            if (excelFieldName != null) {
                ret.put(excelFieldName.value, value)
                continue
            }
        }
        return ret
    }

    private fun getCellFormatValue(cell: HSSFCell?): String {
        var cellvalue = ""
        if (cell != null) {
            // 判断当前Cell的Type
            when (cell.cellTypeEnum) {
            // 如果当前Cell的Type为NUMERIC
                CellType.NUMERIC, CellType.FORMULA -> {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式

                        //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();

                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        val date = cell.dateCellValue
                        val sdf = SimpleDateFormat("yyyy-MM-dd")
                        cellvalue = sdf.format(date)

                    } else {
                        // 取得当前Cell的数值
                        cellvalue = cell.numericCellValue.toString()
                    }// 如果是纯数字
                }
            // 如果当前Cell的Type为STRIN
                CellType.STRING ->
                    // 取得当前的Cell字符串
                    cellvalue = cell.richStringCellValue.string
            // 默认的Cell值
                else -> cellvalue = " "
            }
        } else {
            cellvalue = ""
        }
        return cellvalue
    }

    @Throws(IOException::class)
    fun saveExcel(fileName: String, workbook: HSSFWorkbook) {

        var fout: FileOutputStream? = null
        try {
            fout = FileOutputStream(fileName)
            workbook.write(fout)
            fout.flush()
        } catch (e: FileNotFoundException) {
            throw e
        } catch (e: IOException) {
            throw e
        } finally {
            if (fout != null) {
                try {
                    fout.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }

    }
}//获取id与java bean field的关系
