var contexts = ["page"];
for (var i = 0; i < contexts.length; i++) {
  var context = contexts[i];
  var title = "MSRIT SIS Autofill";
  var id =  chrome.contextMenus.create({"title": title, "contexts":[context],"onclick": genericOnClick});
}

function genericOnClick()
{
//var wd=window.open("getfilehandler.html");

var fourmTabs = new Array();
chrome.tabs.query({}, function (tabs) {
    for (var i = 0; i < tabs.length; i++) {
        fourmTabs[i] = tabs[i];
    }
    // Moved code inside the callback handler
    for (var i = 0; i < fourmTabs.length; i++) {
        if (fourmTabs[i] != null)
           window.console.log(fourmTabs[i].url);
        else {
            window.console.log("??" + i);
        }
    }
});

//createProperties("getfilehandler.html",true);
chrome.tabs.create({url:"getfilehandler.html"},function (tabs){});

window.addEventListener("storage", function(event) {
 var key = event.key;
 var newValue = event.newValue;
 var oldValue = event.oldValue;
 var url = event.url;
 var storageArea = event.storageArea;
///
var fileContents=localStorage["marksData"];
alert('These are your file contents: '+ fileContents); 
///  finally! got the file contents back to the page that I wanted!!!!!
// handle the event

var loc=prompt('Enter the link of the page that you want to autofill');
//alert(loc);
//loc is the link of page that we want to modify
var marksArray= fileContents.split(" ");
/*
for(i=0;i<marksArray.length;i++)
{
alert(marksArray[i]);
}
got the split here!
*/
//chrome.tabs.create({url:loc},function (tabs){});

//alert('came here!');

//document.alert('came here');

//var viewTabUrl = chrome.extension.getURL(loc);
//var f=document.getElementById('1').innerHTML=marksArray[0];
//alert(f);
    // Moved code inside the callback handler
   
chrome.tabs.update({url:loc});

document.getElementById('1').innerHTML=marksArray[0];





});
// <moved code inside callback function of chrome.tabs.query
}





