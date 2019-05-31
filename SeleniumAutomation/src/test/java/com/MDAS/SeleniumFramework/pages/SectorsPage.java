package com.MDAS.SeleniumFramework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.MDAS.SeleniumFramework.utilities.Driver;

public class SectorsPage {
	public  List<WebElement> industriesText;
	public SectorsPage(){
		PageFactory.initElements(Driver.getDriver(),this);
		industriesText=IndustriesPanel.findElements(By.cssSelector("span"));
		
	}
	@FindBy(how=How.CSS,using="button.MuiButtonBase-root:nth-of-type(1)")
    public WebElement sectors_tab;
    /*
     * SECTORS TAB 	css	button.MuiButtonBase-root:nth-of-type(1)
COMPANIES TAB	css	button.MuiButtonBase-root:nth-of-type(2)
HOW IT WORKS	css	button.MuiButtonBase-root:nth-of-type(3)
SEARCH BOX	css	"input[placeholder='Ask Raven...']"
EYE GLASS ICON	css	"scv.MuiSvgIcon-root"
Raven's Analysis	css	"span.MuiTab-wrapper:nth-of-type(1)"
NASDAQ Analysis	css	"span.MuiTab-wrapper:nth-of-type(2)"
Typography<object>	css	"h6.MuiTypography-root.MuiTypography-h6"
Companies Breadcrumb	css	"div.MuiChip-root"
Sector Analysis	css	"div.MuiPaper-root.MuiPaper-elevation2.MuiPaper-rounded"
     */
    @FindBy(how=How.CSS,using="button.MuiButtonBase-root:nth-of-type(2)")
    public WebElement companies_tab;
    
    @FindBy(how=How.CSS,using="button.MuiButtonBase-root:nth-of-type(3)")
    public WebElement trainingData_tab;
    
    @FindBy(how=How.CSS,using="input[placeholder='Ask Raven...']")
    public WebElement search_box;
    
    @FindBy(how=How.CSS,using="scv.MuiSvgIcon-root")
    public WebElement eye_glass_icon;
    
    @FindBy(how=How.CSS,using="span.MuiTab-wrapper:nth-of-type(1)")
    public WebElement ravens_analysis;
    
    @FindBy(how=How.CSS,using="span.MuiTab-wrapper:nth-of-type(2)")
    public WebElement nasdaq_analysis;
    
    @FindBy(how=How.CSS,using="h6.MuiTypography-root.MuiTypography-h6")
    public List<WebElement> ravensSector;
    
      
    @FindBy(how=How.CSS,using="div.MuiChip-root")
    public WebElement companies_breadcrumb;
    
    @FindBy(how=How.CSS,using="div.MuiPaper-root.MuiPaper-elevation2.MuiPaper-rounded")
    public WebElement sector_analysis;
	/*
	 * left Pie	css	"canvas.chartjs-render-monitor:nth-of-type(1)"		
right canva	css	"canvas.chartjs-render-monitor:nth-of-type(2)"		
One company	css	"div#panel1a-header"		
One company>Company Name	css	"h6.MuiTypography-root.MuiTypography-h6"	all	
One company>Company description	css	"span.MuiTypography-root"		
One company>More icon	css	"svg.MuiSvgIcon-root"		
One company Detail table	css	"div.MuiCollapse-container.MuiCollapse-entered"		
analysisSectors	css	"div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-10"	all	
analysisRatings	css	"div.MuiGrid-root.MuiGrid-item.MuiGrid-align-items-xs-flex-end.MuiGrid-grid-xs-2"	all	
left vector	css	"canvas.chartjs-render-monitor:nth-of-type(1)"		
right vector	css	"canvas.chartjs-render-monitor:nth-of-type(2)"		
sectorsNasdaq	css	"div.MuiGrid-root.MuiGrid-item>h6.MuiTypography-root.MuiTypography-h6"	all	this is the Sectors on the NASDAQ sub tab

	 */
    
    @FindBy(how=How.CSS,using="canvas.chartjs-render-monitor:nth-of-type(1)")
    public WebElement leftPie;
    
    @FindBy(how=How.CSS,using="canvas.chartjs-render-monitor:nth-of-type(2)")
    public WebElement rightCanva;
    
    @FindBy(how=How.CSS,using="div#panel1a-header")
    public WebElement company;
    
    @FindBy(how=How.CSS,using="h6.MuiTypography-root.MuiTypography-h6")
    public List<WebElement> companyName;
    
    @FindBy(how=How.CSS,using="span.MuiTypography-root")
    public WebElement companyDescription;
    
    @FindBy(how=How.CSS,using="svg.MuiSvgIcon-root")
    public WebElement moreIcon;
    
    @FindBy(how=How.CSS,using="div.MuiCollapse-container.MuiCollapse-entered")
    public WebElement detailTable;
    
    @FindBy(how=How.CSS,using="div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-10")
    public List<WebElement> analysisSectors;
    
    @FindBy(how=How.CSS,using="div.MuiGrid-root.MuiGrid-item.MuiGrid-align-items-xs-flex-end.MuiGrid-grid-xs-2")
    public List<WebElement> analysisRatings;
    
    @FindBy(how=How.CSS,using="canvas.chartjs-render-monitor")
    public List<WebElement> vectors;
    
    @FindBy(how=How.CSS,using="canvas.chartjs-render-monitor:nth-of-type(1)")
    public WebElement leftVector;
    
    @FindBy(how=How.CSS,using="canvas.chartjs-render-monitor:nth-of-type(2)")
    public WebElement rightVector;
    
    @FindBy(how=How.CSS,using="div.MuiGrid-root.MuiGrid-item>h6.MuiTypography-root.MuiTypography-h6")
    public List<WebElement> sectorsNasdaq;
    
    
    @FindBy(how=How.CSS,using="div.MuiGrid-root.MuiGrid-container[style*='20px']:nth-of-type(1)")
    public WebElement IndustriesPanel;
    
//    @FindBy(how=How.CSS,using="IndustriesPanel.findElements('span')")
//    public List<WebElement> industriesText;
    
    
}
