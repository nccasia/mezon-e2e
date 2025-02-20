# Mezon End to End Testing

Katalon Studio is a free and easy-to-use automated functional and regression testing platform. It provides users the ability to implement full automated testing solutions for their application projects with minimal engineering and programming skill requirements.
______
The **katalon-bdd-cucumber-tests** perform UI & API functional automation tests written in BDD Cucumber format on Jira Web Application using Katalon Studio. The examples in this project range from common to advanced test cases.

## Companion products

### Katalon TestOps

[Katalon TestOps](https://analytics.katalon.com) is a web-based application that provides dynamic perspectives and an insightful look at your automation testing data. You can leverage your automation testing data by transforming and visualizing your data; analyzing test results; seamlessly integrating with such tools as Katalon Studio and Jira; maximizing the testing capacity with remote execution.

* Read our [documentation](https://docs.katalon.com/katalon-analytics/docs/overview.html).
* Ask a question on [Forum](https://forum.katalon.com/categories/katalon-analytics).
* Request a new feature on [GitHub](CONTRIBUTING.md).
* Vote for [Popular Feature Requests](https://github.com/katalon-analytics/katalon-analytics/issues?q=is%3Aopen+is%3Aissue+label%3Afeature-request+sort%3Areactions-%2B1-desc).
* File a bug in [GitHub Issues](https://github.com/katalon-analytics/katalon-analytics/issues).

### Katalon Studio
[Katalon Studio](https://www.katalon.com) is a free and complete automation testing solution for Web, Mobile, and API testing with modern methodologies (Data-Driven Testing, TDD/BDD, Page Object Model, etc.) as well as advanced integration (JIRA, qTest, Slack, CI, Katalon TestOps, etc.). Learn more about [Katalon Studio features](https://www.katalon.com/features/).

## Getting Started
These instructions will get you a copy of the project up and running on your local machine.

### Important Notes:
- **This sample project is compatiple to Katalon version 5.7 and above only.**
- katalon-bdd-cucumber-tests project airms to demonstrate how to express Test Cases (or Test Scenarios) in Cucumber format using Gherkin language. To make the test easier to understand by users, this sample project is built on top of two other sample projects:
    + [Jira UI Tests](https://github.com/katalon-studio-samples/jira-ui-tests)
    + [Jira API Tests](https://github.com/katalon-studio-samples/jira-api-tests)
- You might need to explore these two projects before starting this project for better understanding.

### Prerequisites
- [Katalon Studio](https://www.katalon.com/) - [Installation and Setup](https://docs.katalon.com/x/HwAM)
- Internet access
- Application Under Test (AUT):
     + Jira cloud: https://katalon.atlassian.net/
     + Account: demo@katalon.com/sPiHQ&YEa6ST`de+
### Setting Up
- [Check out](https://git-scm.com/book/en/v2/Git-Basics-Getting-a-Git-Repository) the code from this repository
- [Open the project](https://docs.katalon.com//display/KD/Manage+Test+Project) from Katalon Studio
### Executing a Feature
![Execute a simple feature](https://github.com/katalon-studio-samples/katalon-bdd-cucumber-tests/blob/master/Tutorials/Figures/Execute%20a%20feature.png?raw=true)
1. Expand the **Include** structure, where all the features and step definition scripts located
2. Select the **Feature** you want to execute
3. Execute the **Feature**

At the end of this README, you will find additional ways to execute automation test cases. 
## Test Features
Below is the list of all the available features in this project relating to the test scenarios as described. Simply select the test feature you want to run in Katalon Studio and execute accordingly. You can also make additional changes in these test features to get familiar with automation testing and specifically Katalon Studio. 
### Story: Verify issue information feature
```Gherkin     
@Issue_Tests
Feature: Verify issue information

Background:
  Given The Jira System is available

  @Get_By_Id
  Scenario: Verify issue information by Id
    When I get information of an issue with Id "KD-1"
    Then I get response code "200"
    And The issue information as below:
        |project_key |issue_type |priority |summary                          |
        |KD          |Bug        |Low      |REST - Create new issue using API|
        
  @Get_By_Id
  Scenario Outline: Verify issue information by Id
    When I get information of an issue with Id "<issue_key>"
    Then I get response code "200"
    And The issue information as below:
        |project_key   |issue_type   |priority   |summary   |
        |<project_key> |<issue_type> |<priority> |<summary> |
        
  Examples:
  |issue_key|project_key |issue_type |priority |summary                          |
  |KD-1     |KD          |Bug        |Low      |REST - Create new issue using API|
  |KD-2     |KD          |Bug        |Low      |Update summary from API example  |
``` 
## See Also
Update configurations for integration: [Jira](https://docs.katalon.com/x/7oEw), [Katalon TestOps](https://docs.katalon.com/x/KRhO)

Katalon Documentation: http://docs.katalon.com/, especially some [Tips and Tricks](https://docs.katalon.com/x/PgXR) to run a successful automation test. 

Katalon Forum: https://forum.katalon.com/

Katalon Business Support: https://www.katalon.com/support-service-options/


# Profiles

Dev – Public Channel – Public Thread: This means testing in the development environment, with a public thread in a public channel.
Variables:
 * host: The homepage URL of Mezon.
 * baseURL: The login page URL.
 * email, password: Test account credentials.
 * channel: Channel object.
 * channelID: Channel ID.
 * isThread: Used to determine if the test is within a thread.
 * isPrivateThread: Used to determine if it is a private thread.

Dev – Group Message: This means testing in the development environment, within group chats.
Variables: 
 * host, 
 * baseURL, 
 * email, password
 * isDirectMessage: Determines if the test is in a direct message.
 * isGroupMessage: Determines if the test is in a group chat.

# Custom Keywords 
[Attribute.add] Used to add attributes to an element.
syntax: CustomKeywords.'mezon.Attribute.add'(testObject, name, value)
 * name: The name of the attribute (String).
 * value: The value of the attribute (String).
Example:
CustomKeywords.'mezon.Attribute.add'(findTestObject('Object Repository/Channel Message/Copy Image/img_Image Message'), 'id', 'test-id');

[ConvertFile.toString] Used to convert file data into a String.
syntax: CustomKeywords.'mezon.ConvertFile.toString'(path)
 * path: The file path (String).
Example:
CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Image\\logo NCC.png');

[Element.getXPath] Used to retrieve the XPath of an element.
syntax: CustomKeywords.'mezon.Element.getXPath'(element)
 * element: The WebElement.
Example:
WebElement channelElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'));
CustomKeywords.'mezon.Element.getXPath'(channelElement);

[File.getPath] Used to retrieve the full file path.
syntax: CustomKeywords.'mezon.File.getXPath'(path)
 * path: The file path (String).
Example:
CustomKeywords.'mezon.File.getXPath'('\\Data Files\\Image\\logo NCC.png');

[GetTestObject.withXpath] Used to create a TestObject from an XPath.
syntax: CustomKeywords.'mezon.GetTestObject.withXpath'(xpath)
 * xpath: The XPath (String).
Example:
String xpath = "//*[@id='msg-46541168498']";
TestObject MessageObj = CustomKeywords.'mezon.GetTestObject.withXpath'(xpath);

[Random.text] Used to generate random String.
syntax: CustomKeywords.'mezon.Random.text'(text)
 * Text: The text pattern (String).
Example:
CustomKeywords.'mezon.Random.text'("message");

[SendText.SendText] Set text and send the Enter key at input/textarea.
syntax: CustomKeywords.'SendText.SendText'(Object)
 * Object: The TestObject.
Example:
CustomKeywords.'SendText.SendText'(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea'));

[SendingMessage.isSendingMessage] Verifies if a message is in a sending state.
syntax: CustomKeywords.'SendingMessage.isSendingMessage'(Object)
 * Object: The TestObject.
Example:
CustomKeywords.'SendingMessage.isSendingMessage'();
CustomKeywords.'SendingMessage.isSendingMessage'(findTestObject('Channel Message/Send message/message container'));

[VerifyHrefImgExists.VerifyHrefImgExists] Checks if an image tag within an element contains the specified src.
syntax: CustomKeywords.'VerifyHrefImgExists.VerifyHrefImgExists'(Object, src)
 * Object: The TestObject.
 * src: The image link.

[VerifySaveImage.VerifySaveImage] Checks if the downloaded PNG file exists in the specified folder.
syntax: CustomKeywords.'VerifySaveImage.VerifySaveImage'(folder, fileName)
 * folder: The folder path (String).
 * fileName: The file name.
Example:
String home = System.getProperty('user.home');
String userDownloads = new File(home + '/Downloads/');
CustomKeywords.'VerifySaveImage.VerifySaveImage'(userDownloads, 'image');

Note
•	Request developers to add a data-id attribute containing the message ID to the buttons for "jump to pinned message" and "jump to reply message" for easier verification.
•	Currently, the sidebar in threads has changed, so test cases for selecting channels need to be updated.

