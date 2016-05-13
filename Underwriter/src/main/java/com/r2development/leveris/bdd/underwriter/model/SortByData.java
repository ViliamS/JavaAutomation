package com.r2development.leveris.bdd.underwriter.model;

import com.r2development.leveris.utils.Enums.SORT;
import com.r2development.leveris.utils.Enums.SORTBY;
import org.junit.Assert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortByData {

    protected Map<SORTBY, SORT> data = new LinkedHashMap<>();

    public SortByData(Map<String, String> data) {
        this.data.putAll(validateAndConvertData(data));
    }

    private static Map<SORTBY, SORT> validateAndConvertData(Map<String, String> oldData){
        Map<SORTBY, SORT> newData = new LinkedHashMap<>();
        for (Map.Entry<String, String> dataEntry : oldData.entrySet()) {

            SORTBY key = SORTBY.EMPTY;
            SORT value = SORT.EMPTY;

            if(dataEntry.getKey().equalsIgnoreCase(SORTBY.CREATION_DATE.getString())){
                key = SORTBY.CREATION_DATE;
            } else if(dataEntry.getKey().equalsIgnoreCase(SORTBY.STAGE_SUBMISSION_DATE.getString())){
                key = SORTBY.STAGE_SUBMISSION_DATE;
            } else {
                Assert.assertTrue("\n Provided Cucumber Variables Table Entry for 'Sort By' contains not supported entry name or value : \n | " + dataEntry.getKey() + " | " + dataEntry.getValue() + " | \n", false);
            }

            if(dataEntry.getValue().equalsIgnoreCase(SORT.ASC.getString())){
                value = SORT.ASC;
            } else if(dataEntry.getValue().equalsIgnoreCase(SORT.DESC.getString())){
                value = SORT.ASC;
            } else {
                Assert.assertTrue("\n Provided Cucumber Variables Table Entry for 'Sort By' contains not supported entry name or value : \n | " + dataEntry.getKey() + " | " + dataEntry.getValue() + " | \n", false);
            }

            newData.put(key, value);
        }
        return newData;
    }

    public SortByData(List<String> dataList) {
        int i=0;
        Map<String, String> preData = new LinkedHashMap<>();
        do {
            preData.put(dataList.get(i), dataList.get(i+1));
            i=i+2;
        } while (i<(dataList.size()-1));
        new DataModel(preData);
    }

    public SORT get(SORTBY key) {
        return ( data.containsKey(key) ? data.get(key) : null);
    }

    public Map<SORTBY, SORT> getData() {
        return data;
    }

}
