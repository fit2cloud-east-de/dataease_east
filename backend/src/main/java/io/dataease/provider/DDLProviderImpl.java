package io.dataease.provider;

import io.dataease.base.domain.DatasetTableField;
import io.dataease.commons.utils.Md5Utils;

import java.util.Arrays;
import java.util.List;

public class DDLProviderImpl extends DDLProvider {
    @Override
    public String createView(String name, String viewSQL) {
        return null;
    }

    @Override
    public String dropTable(String name) {
        return null;
    }

    @Override
    public String dropView(String name) {
        return null;
    }

    @Override
    public String replaceTable(String name) {
        return null;
    }

    @Override
    public String createTableSql(String name, List<DatasetTableField> datasetTableFields) {
        return null;
    }

    @Override
    public String insertSql(String name, List<String[]> dataList, int page, int pageNumber) {
        String insertSql = "INSERT INTO TABLE_NAME VALUES ".replace("TABLE_NAME", name);
        StringBuffer values = new StringBuffer();

        Integer realSize = page * pageNumber < dataList.size() ? page * pageNumber : dataList.size();
        for (String[] strings : dataList.subList((page - 1) * pageNumber, realSize)) {
            values.append("(").append(Md5Utils.md5(String.join(",", Arrays.asList(strings))))
                    .append("," ).append(String.join(",", Arrays.asList(strings)))
                    .append("),");
        }
        return insertSql + values.substring(0, values.length() - 1);
    }


}
