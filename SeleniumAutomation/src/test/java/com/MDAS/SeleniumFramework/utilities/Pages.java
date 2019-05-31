package com.MDAS.SeleniumFramework.utilities;

import com.MDAS.SeleniumFramework.pages.*;

public class Pages {
private CompaniesPage companiesPage;
private SectorsIndustriesPage sectorsIndustriesPage;
private SearchResultPage searchResultPage;
private SectorsPage sectorsPage;
private TrainingDataPage trainingDataPage;

public SectorsPage landingPage() {
    if (sectorsPage == null) {
    	sectorsPage = new SectorsPage();
    }
    return sectorsPage;
}

public CompaniesPage companies() {
    if (companiesPage == null) {
    	companiesPage = new CompaniesPage();
    }
    return companiesPage;
}

public SectorsIndustriesPage sectorsIndustries() {
    if (sectorsIndustriesPage == null) {
    	sectorsIndustriesPage = new SectorsIndustriesPage();
    }
    return sectorsIndustriesPage;
}

public SearchResultPage searchResult() {
    if (searchResultPage == null) {
    	searchResultPage = new SearchResultPage();
    }
    return searchResultPage;
}

public TrainingDataPage trainingDataPage() {
    if (trainingDataPage == null) {
    	trainingDataPage = new TrainingDataPage();
    }
    return trainingDataPage;
}

}
