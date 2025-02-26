package net.meetsky.pages;

import net.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {

    public FilesPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//li[@data-id='files'])[1]")
    public WebElement fileIconOnTop;

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement fileAddIcon;

    @FindBy(xpath = "//label[@for='file_upload_start']")
    public WebElement fileUploadStart;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement fileUploadButton;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> fileNamesList;

    @FindBy(xpath = "(//span[@class='displayname'])[2]")
    public WebElement fileNewFolder;

    @FindBy(xpath = "//input[@id='view11-input-folder']/following-sibling::input")
    public WebElement fileNewFolderButton;

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public  List<WebElement> fileMoreButtons;

    @FindBy(xpath = "//a[@class='menuitem action action-delete permanent']")
    // file-> //a[@class='menu-option option-delete']
    // folder //a[@class='menuitem action action-delete permanent']
    public WebElement fileDeleteButton;

    @FindBy(xpath = "//span[starts-with(@class, 'dirinfo')]")
    public WebElement folderInfoText;

    @FindBy(xpath = "//span[starts-with(@class, 'fileinfo')]")
    public WebElement fileInfoText;

    @FindBy(xpath = "//div[@class='tooltip-inner']")
    public WebElement folderAlreadyExistsMessage;

    public boolean isFileOnTheList (List<WebElement> fileNameList, String fileName){
        boolean isFileOnTheList = false;
        for (WebElement name : fileNameList) {
            System.out.println(name.getText());
            if (name.getText().contains(fileName)) {
                isFileOnTheList = true;
                break;
            }
        }
        return isFileOnTheList;
    }

}

