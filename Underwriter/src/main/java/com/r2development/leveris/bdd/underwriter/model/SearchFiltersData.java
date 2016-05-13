package com.r2development.leveris.bdd.underwriter.model;

import com.r2development.leveris.utils.Enums.SEARCHFILTERS;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class SearchFiltersData extends DataModel {

    public SearchFiltersData(Map<String, String> filters) {
        super(filters);
        validateFilterNames();
    }

    public SearchFiltersData(List<String> filters) {
        super(filters);
        validateFilterNames();
    }

    private void validateFilterNames(){
        Map<String, String> filters = this.data;
        for(Map.Entry<String, String> oneEntry : filters.entrySet()){
            try {
                SEARCHFILTERS.getFilter(oneEntry.getKey());
            } catch (IllegalArgumentException exception){
                System.out.println("Exception : " + exception);
                Assert.assertTrue("\n Provided Cucumber Variables Table Entry for 'Search Filters' contains not supported variableName : \n | " + oneEntry.getKey() + " | " + oneEntry.getValue() + " | \n", false);
            }
        }
    }

    /** even the methods are not neened it is nice to have */

    public void setAssignedFilter(String assignedFilterValueToSet){
        data.replace(SEARCHFILTERS.ASSIGNED.getFilterName(), assignedFilterValueToSet);
    }

    public void setCaseFilter(String caseFilterValueToSet){
        data.replace(SEARCHFILTERS.CASE.getFilterName(), caseFilterValueToSet);
    }

    public void setStatusFilter(String statusFilterValueToSet){
        data.replace(SEARCHFILTERS.STATUS.getFilterName(), statusFilterValueToSet);
    }

    public void setSearchTextFilter(String searchTextFilterValueToSet){
        data.replace(SEARCHFILTERS.SEARCH_TEXT.getFilterName(), searchTextFilterValueToSet);
    }

    public String setApplicationIdFilter(){
        return data.get(SEARCHFILTERS.APPLICATION_ID.getFilterName());
    }

    public String getAssignedFilter(){
        return data.get(SEARCHFILTERS.ASSIGNED.getFilterName());
    }

    public String getCaseFilter(){
        return data.get(SEARCHFILTERS.CASE.getFilterName());
    }

    public String getStatusFilter(){
        return data.get(SEARCHFILTERS.STATUS.getFilterName());
    }

    public String getSearchTextFilter(){
        return data.get(SEARCHFILTERS.SEARCH_TEXT.getFilterName());
    }

    public String getApplicationIdFilter(){
        return data.get(SEARCHFILTERS.APPLICATION_ID.getFilterName());
    }

}
