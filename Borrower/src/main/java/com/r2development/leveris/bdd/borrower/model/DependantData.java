package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class DependantData extends DataModel {

    public DependantData(Map<String, String> dependantData) {
        super(dependantData);
    }

    public DependantData(List<String> dependantData) {
        super(dependantData);
    }

//    public DependantData(Map<String, DependantData> dependantData) { super(dependantData); }

    public String getDateOfBirth(){
        return data.get("dateOfBirth");
    }

}

/**

 And Borrower fills in "Dependant form"
 | dateOfBirth | 01/01/2000 |

 */