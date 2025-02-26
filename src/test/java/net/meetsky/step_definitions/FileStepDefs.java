package net.meetsky.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.meetsky.pages.FilesPage;
import net.meetsky.utilities.BrowserUtils;
import net.meetsky.utilities.Driver;
import org.junit.Assert;


public class FileStepDefs {

    FilesPage filePage = new FilesPage();
    int numberOfFiles;
    int numberOfFolders;
    @Given("the user navigates to the {string} module")
    public void the_user_navigates_to_the_module(String string) {
        filePage.fileIconOnTop.click();
    }

    @Given("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {
        filePage.fileAddIcon.click();
    }

    @And("the user selects a valid file {string} to upload")
    public void theUserSelectsAValidFileToUpload(String fileName) {

        filePage.fileUploadStart.click();
        BrowserUtils.waitFor(1);

        //String filePath = "C:\\Users\\C\\OneDrive\\Desktop\\"+fileName;
        filePage.fileUploadButton.sendKeys(fileName);
        System.out.println("fileName = " + fileName);
        BrowserUtils.waitFor(3);
    }


    @Then("the uploaded {string} should be displayed in the files list")
    public void theUploadedShouldBeDisplayedInTheFilesList(String fileName) {
        Driver.getDriver().navigate().refresh();
        Assert.assertTrue(filePage.isFileOnTheList(filePage.fileNamesList, fileName));

    }


    @Given("the user clicks on the New Folder button")
    public void the_user_clicks_on_the_new_folder_button() {
        BrowserUtils.waitForClickablility(filePage.fileNewFolder, 8);
        filePage.fileNewFolder.click();

        BrowserUtils.waitForClickablility(filePage.fileNewFolderButton, 8);
        filePage.fileNewFolderButton.click();

    }

    @Then("the new folder {string} should be displayed in the files list")
    public void the_new_folder_should_be_displayed_in_the_files_list(String fileName) {
        Driver.getDriver().navigate().refresh();
        Assert.assertTrue(filePage.isFileOnTheList(filePage.fileNamesList, fileName));
    }

    @Given("the user clicks on the three dots menu next to the file {string}")
    public void the_user_clicks_on_the_three_dots_menu_next_to_the_file(String string) {

        int lastindex = filePage.fileMoreButtons.size() - 1;
        filePage.fileMoreButtons.get(lastindex).click();
    }

    @Given("the user selects the {string} option")
    public void the_user_selects_the_option(String string) {
        BrowserUtils.clickWithJS(filePage.fileDeleteButton);
    }


    @Then("the file {string} should no longer be displayed in the files list")
    public void the_file_should_no_longer_be_displayed_in_the_files_list(String fileName) {
        Driver.getDriver().navigate().refresh();
        Assert.assertFalse(filePage.isFileOnTheList(filePage.fileNamesList, fileName));

    }

    @Then("the total number of files and folders should be displayed under the files list table")
    public void the_total_number_of_files_and_folders_should_be_displayed_under_the_files_list_table() {

        BrowserUtils.waitFor(3);
        String numberOfFolderText = filePage.folderInfoText.getText();
        numberOfFolders = Integer.parseInt(numberOfFolderText.replaceAll("[^0-9]", ""));
        System.out.println("numberOfFolders = " + numberOfFolders);
        String numberOfFileText = filePage.fileInfoText.getText();
        numberOfFiles = Integer.parseInt(numberOfFileText.replaceAll("[^0-9]", ""));
        System.out.println("numberOfFiles = " + numberOfFiles);
        Assert.assertTrue(filePage.folderInfoText.isDisplayed());
    }

    @And("the user refresh the page")
    public void theUserRefreshThePage() {
        Driver.getDriver().navigate().refresh();
    }

    @Then("an error message should be displayed stating {string}")
    public void an_error_message_should_be_displayed_stating(String string) {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(filePage.folderAlreadyExistsMessage.isDisplayed());
    }


    @Then("the total number of the file is increased one")
    public void theTotalNumberOfTheFileIsIncreasedOne() {
        int oldNumberOfFiles = numberOfFiles;
        BrowserUtils.waitForVisibility(filePage.fileInfoText,2);
        String numberOfFileText = filePage.fileInfoText.getText();
        numberOfFiles = Integer.parseInt(numberOfFileText.replaceAll("[^0-9]", ""));
        System.out.println("numberOfFiles = " + numberOfFiles);
        Assert.assertEquals(oldNumberOfFiles+1, numberOfFiles);
    }

    @Then("the total number of the file is decreased one")
    public void theTotalNumberOfTheFileIsDecreasedOne() {
        int oldNumberOfFiles = numberOfFiles;
        BrowserUtils.waitForVisibility(filePage.fileInfoText,2);
        String numberOfFileText = filePage.fileInfoText.getText();
        numberOfFiles = Integer.parseInt(numberOfFileText.replaceAll("[^0-9]", ""));
        System.out.println("numberOfFiles = " + numberOfFiles);
        Assert.assertEquals(oldNumberOfFiles-1, numberOfFiles);
    }

    @Then("the total number of the folder is increased one")
    public void theTotalNumberOfTheFolderIsIncreasedOne() {
        int oldNumberOfFolders = numberOfFolders;
        BrowserUtils.waitForVisibility(filePage.folderInfoText,2);
        String numberOfFolderText = filePage.folderInfoText.getText();
        numberOfFolders = Integer.parseInt(numberOfFolderText.replaceAll("[^0-9]", ""));
        System.out.println("numberOfFolders = " + numberOfFolders);
        Assert.assertEquals(oldNumberOfFolders+1, numberOfFolders);
    }
}
