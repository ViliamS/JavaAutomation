package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.r2development.leveris.bdd.borrower.model.DependantData;
import com.r2development.leveris.di.IABorrowerHttpContext;
import com.r2development.leveris.di.IBorrowerHttpResponse;
import com.r2development.leveris.di.IUser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.*;

//@Singleton
public class ApiYourDependantsStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourDependantsStepDef.class.getName());

    @Inject
    IABorrowerHttpContext localContext;
    @Inject
    private IUser user;
    @Inject
    IBorrowerHttpResponse httpResponse;

    private boolean isThereDependantList = false;
    private String btnHiddenSubmitWicketInterface = StringUtils.EMPTY;
    private String btnRefreshSubmitWicketInterface = StringUtils.EMPTY;
    private String btnCloseWicketInterface = StringUtils.EMPTY;

    @Inject
    public ApiYourDependantsStepDef(IBorrowerHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
        isThereDependantList = false;
    }

    @Given("^(Borrower) fills in \"Dependant form\"$")
    public void user_fills_in_account(String userType, List<String> accountDataMap) throws IOException {
        DependantData dependantData = new DependantData(accountDataMap);

        user_clicks_add_dependant(userType);

        if (!StringUtils.isEmpty(dependantData.getDateOfBirth())){
            user_types_dependant_date_of_birth(userType, dependantData.getDateOfBirth());
        }
        user_clicks_save_and_close(userType);
    }

    @When("^(Borrower) has(n't)? dependants$")
    public void user_has_dependants(String userType, String hasDependants) throws IOException {
        if (hasDependants == null)
            user_clicks_add_dependant(userType);
        else {
            borrower_clicks_i_have_none_dependant(userType);
            user_clicks_dependants_next(userType);
        }
    }

    @And("^(Borrower) types the Dependant date of birth: (.*)$")
    public void user_types_dependant_date_of_birth(String userType, String dateOfBirth) {
        dependantParameters.put("root:c:w:pnlAddNew:c:w:pnlBorrower:c:w:chkBorrowerOne:checkbox","on");
        dependantParameters.put("root:c:w:pnlAddNew:c:w:txtDateOfBirth:tb",dateOfBirth);
    }

    @And("^(Borrower) clicks \"ADD THIS DEPENDANT\"$")
    public void user_clicks_add_this_dependant(String userType) {
    }

    @And("^(Borrower) clicks \"Save and Close\"$")
    public void user_clicks_save_and_close(String userType) throws IOException {

        Map<String, String> finalDependantParameters = new LinkedHashMap<>();

        switch ( userType ) {
            case "Borrower":
                finalDependantParameters.putAll(dependantParameters);
                break;
            default:
                log.debug("Huston we have a problem when finalizing EmploymentIncomeParameters");
        }

        Document currentFormDoc = Jsoup.parse(httpResponse.getHttpResponse());
        Document currentFormDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for (String aComponentId : componentId) {
            try {
                currentFormDoc2 = Jsoup.parse(currentFormDoc.select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                log.info("is " + aComponentId);
                break;
            } catch (NullPointerException npe) {
                log.info("isnot " + aComponentId);
            }
        }

        String stepToken = currentFormDoc2.select("input[name=stepToken]").attr("value");

        String btnAddDependent = currentFormDoc2.select("a[id~=submit]").select("a[wicketpath~=main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_btnAddDependent").attr("onclick");
        Pattern pBtnAddDependent = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnAddDependent = pBtnAddDependent.matcher(btnAddDependent);
        String btnAddDependentWicketInterface = StringUtils.EMPTY;
        while( mBtnAddDependent.find() ) {
            btnAddDependentWicketInterface = mBtnAddDependent.group(1);
        }

        finalDependantParameters.put("stepToken", stepToken);
        finalDependantParameters.put("root:c:w:pnlAddNew:c:w:btnAddDependent:submit", "1");

        // ?? retrieve wicket:interface

        String employmentLinkAddResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlAddNew:c:w:btnAddDependent:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnAddDependentWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                finalDependantParameters,
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(employmentLinkAddResponse);

        Document currentClose = Jsoup.parse(currentFormDoc.select("component[id~=close]").select("component[encoding~=wicket]").text());
        Pattern pClose = Pattern.compile("\\?(wicket:interface=.*:)'");
        Matcher mClose = null;
        String linkClose = ":1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:btnAddDependant:close::IBehaviorListener:0:";
        mClose = pClose.matcher(currentClose.select("a[id~=close]").select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnAddDependant_close").attr("onclick"));

        while( mClose.find() )
            linkClose = mClose.group(1);

        if ( isThereDependantList) {
            linkClose = ":1:main:c:form:form:root:c:w:pnlDepList:c:w:btnAddDep:close::IBehaviorListener:0:";
            linkClose = btnCloseWicketInterface;
        }

        requestHttpGet(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=" + linkClose,
                System.getProperty("borrower.url") + "/form.2?" + linkClose,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        if ( !isThereDependantList) {
            String addDependantCompleted = requestHttpPost(
                    httpClient,
//                    System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:",
                    System.getProperty("borrower.url") + "/form.2?" + btnHiddenSubmitWicketInterface,
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", stepToken);
                            put("root:c:w:pnlNoEmplyments:c:w:btnHiddenSubmit:submit", "1");
                        }
                    },
                    localContext.getHttpContext(),
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(addDependantCompleted);
        }
        else {
            String addDependantCompleted = requestHttpPost(
                    httpClient,
//                    System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHidenRefresh:submit::IBehaviorListener:0:",
                    System.getProperty("borrower.url") + "/form.2?" + btnRefreshSubmitWicketInterface,
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", stepToken);
                            put("root:c:w:btnHidenRefresh:submit", "1");
                        }
                    },
                    localContext.getHttpContext(),
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(addDependantCompleted);
        }
        isThereDependantList=true;
    }

    @And("^(Borrower) clicks \"ADD DEPENDANT\"$")
    public void user_clicks_add_dependant(String userType) throws IOException {

        Document empListDoc = Jsoup.parse(httpResponse.getHttpResponse());

        Document empListDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for (String aComponentId : componentId) {
            try {
                empListDoc2 = Jsoup.parse(empListDoc.select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                log.info("is " + aComponentId);

                if ( !aComponentId.equals("main"))
                    isThereDependantList = true;

                break;
            } catch (NullPointerException npe) {
                log.info("isnot " + aComponentId);
            }
        }

        Elements divEmploymentTypeAddElements = empListDoc2.select("div[data-path~=pnlNoEmplyments").select("div[data-path~=btnAddDependant]");
        Elements divEmploymentTypeAddElements2 = null;
//        Map<String, String> wicketInterfaceMap = new LinkedHashMap<>();
        String linkAdd = null;
//        String currentKey = "linkAdd";
        if ( divEmploymentTypeAddElements.size() != 0 ) {
            for (Element current : divEmploymentTypeAddElements) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoEmplyments_c_w_").select("a[wicketpath~=btnAddDependant_dialog]").attr("onclick");
                Pattern pWicketInterface = Pattern.compile("\\?wicket:interface=(.*)&");
                Matcher mWicketInterface = pWicketInterface.matcher(currentOnClick);
                String currentWicketInterface = null;
                while (mWicketInterface.find()) {
                    currentWicketInterface = mWicketInterface.group(1);
                }
//                wicketInterfaceMap.put(currentKey, currentWicketInterface);
                linkAdd = currentWicketInterface;
            }
        }
        else {
            isThereDependantList = true;
            divEmploymentTypeAddElements2 = empListDoc2.select("div[data-path~=pnlDepList btnAdd]");
            for (Element current : divEmploymentTypeAddElements2) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath=main_c_form_form_root_c_w_pnlDepList_c_w_btnAddDep_dialog]").attr("onclick");
                Pattern pWicketInterface = Pattern.compile("\\?wicket:interface=(.*)&");
                Matcher mWicketInterface = pWicketInterface.matcher(currentOnClick);
                String currentWicketInterface = null;
                while (mWicketInterface.find()) {
                    currentWicketInterface = mWicketInterface.group(1);
                }
//                wicketInterfaceMap.put(currentKey, currentWicketInterface);
                linkAdd = currentWicketInterface;
            }
        }
        final String finalLinkAdd = linkAdd;

        if ( !isThereDependantList ) {
            String onclickBtnHiddenSubmit = empListDoc2.select("a[wicketpath=main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnHiddenSubmit_submit]").attr("onclick");
            Pattern pBtnHiddenSubmit = Pattern.compile("\\?(wicket:interface=.*)&");
            Matcher mBtnHiddenSubmit = pBtnHiddenSubmit.matcher(onclickBtnHiddenSubmit);
            btnHiddenSubmitWicketInterface = null;
            while ( mBtnHiddenSubmit.find() )
                btnHiddenSubmitWicketInterface = mBtnHiddenSubmit.group(1);
//            main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnHiddenSubmit_submit
        }
        else {
            String onclickBtnRefreshSubmit = empListDoc2.select("a[wicketpath=main_c_form_form_root_c_w_btnHidenRefresh_submit]").attr("onclick");
            Pattern pBtnRefreshSubmit = Pattern.compile("\\?(wicket:interface=.*)&");
            Matcher mBtnRefreshSubmit = pBtnRefreshSubmit.matcher(onclickBtnRefreshSubmit);
            btnRefreshSubmitWicketInterface = null;
            while ( mBtnRefreshSubmit.find() )
                btnRefreshSubmitWicketInterface = mBtnRefreshSubmit.group(1);
//            main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnRefreshSubmit_submit
        }


        String stepToken = empListDoc2.select("input[name=stepToken").attr("value");
        Map<String, String> linkAddParameters = new LinkedHashMap<>();
        linkAddParameters.put("stepToken", stepToken);

        String employmentLinkAddResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:btnAddDependant:dialog::IBehaviorListener:0",
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlDepList:c:w:btnAddDep:dialog::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?wicket:interface=" + finalLinkAdd,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                linkAddParameters,
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(employmentLinkAddResponse);
    }

    @And("^(Borrower) clicks Dependants \"NEXT\"$")
    public void user_clicks_dependants_next(String userType) throws IOException {

        String btnNextSection = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath=main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnNextSection_submit]").attr("onclick");
        Pattern pBtnNextSection = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnNextSection = pBtnNextSection.matcher(btnNextSection);
        String btnNextSectionWicketInterface = StringUtils.EMPTY;
        while(mBtnNextSection.find()) {
            btnNextSectionWicketInterface = mBtnNextSection.group(1);
        }

        String nextSectionResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:btnNextSection:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnNextSectionWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "2");
                        put("root:c:w:pnlNoEmplyments:c:w:btnNextSection:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(nextSectionResponse);
    }

    @And("^(Borrower) clicks \"I HAVE NONE\" Dependant$")
    public void borrower_clicks_i_have_none_dependant(String userType) throws IOException {

        String btnNoneDependants = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=main]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath=main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnNoneDependants_submit]").attr("onclick");
        Pattern pBtnNoneDependants = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnNoneDependants = pBtnNoneDependants.matcher(btnNoneDependants);
        String btnNoneDependantsWicketInterface = StringUtils.EMPTY;
        while(mBtnNoneDependants.find()) {
            btnNoneDependantsWicketInterface = mBtnNoneDependants.group(1);
        }

        String nonDependantsResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:btnNoneDependants:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnNoneDependantsWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                        put("root:c:w:pnlNoEmplyments:c:w:btnNoneDependants:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(nonDependantsResponse);
    }

    @And("^(Borrower) clicks Dependants \"Done\"$")
    public void user_clicks_dependants_done(String userType) throws IOException {

        Document currentFormDoc = Jsoup.parse(httpResponse.getHttpResponse());
        Document currentFormDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for (String aComponentId : componentId) {
            try {
                currentFormDoc2 = Jsoup.parse(currentFormDoc.select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                log.info("is " + aComponentId);
                break;
            } catch (NullPointerException npe) {
                log.info("isnot " + aComponentId);
            }
        }

        String stepToken = currentFormDoc2.select("input[name=stepToken]").attr("value");
        String btnImDone = currentFormDoc2.select("a[wicketpath=main_c_form_form_root_c_w_pnlDepList_c_w_btnImDone_submit]").attr("onclick");
        Pattern pBtnImDone = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnImDone = pBtnImDone.matcher(btnImDone);
        String imDoneWicketInterface = null;
        while ( mBtnImDone.find() )
            imDoneWicketInterface = mBtnImDone.group(1);

        String dependantDoneResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlDepList:c:w:btnImDone:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + imDoneWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", stepToken);
                        put("root:c:w:pnlNoEmplyments:c:w:btnNoneDependants:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(dependantDoneResponse);
    }
}
