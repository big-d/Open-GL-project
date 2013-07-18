


var marks;
var active=0;


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


function sleep(milliseconds) {
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
}




  function readBlob(opt_startByte, opt_stopByte) {

    var files = document.getElementById('files').files;
    if (!files.length) {
      alert('Please select a file!');
      return;
    }

    var file = files[0];
    var start = parseInt(opt_startByte) || 0;
    var stop = parseInt(opt_stopByte) || file.size - 1;

    var reader = new FileReader();

  // If we use onloadend, we need to check the readyState.
    reader.onloadend = function(evt) {
      if (evt.target.readyState == FileReader.DONE) { // DONE == 2
//marks=target.evt.result;       
document.getElementById('byte_content').textContent = evt.target.result;

//////// in this part we can get the file contents into a variable!!!! yay :P
//alert(evt.target.result);

localStorage["marksData"]=evt.target.result;
//alert(localStorage["marksData"]);
localStorage["marksDataAccess"]=1;
//alert(callme()+'wassap');
window.console.log(evt.target.result);    
   document.getElementById('byte_range').textContent = "These are the contents of the file:"
        //['Read bytes: ', start + 1, ' - ', stop + 1,
         //' of ', file.size, ' byte file'].join('');
      }
    };

    var blob = file.slice(start, stop + 1);
    reader.readAsBinaryString(blob);
  }
//var str="adkhaskjdhasodjaslkjdasljdlkasjldjaslkjdaskjdlkajdlkasjlkdjlasjd";
 //localstorage.setItem('test',str);
//alert(localstorage.getItem('test');
  document.querySelector('.readBytesButtons').addEventListener('click', function(evt) {
    if (evt.target.tagName.toLowerCase() == 'button') {
      var startByte = evt.target.getAttribute('data-startbyte');
      var endByte = evt.target.getAttribute('data-endbyte');
        readBlob(startByte, endByte);}



 //console.log('hope this is working!');
  }, false);

/*

//// got the local storage working here!!!!! yay :P
var foo="big_d roxxxx!!!";
localStorage["bar"]=foo;
alert(localStorage["bar"]);
*/
//alert(document.innerHTML);
//// figure out a way to get file contents into a string variable



