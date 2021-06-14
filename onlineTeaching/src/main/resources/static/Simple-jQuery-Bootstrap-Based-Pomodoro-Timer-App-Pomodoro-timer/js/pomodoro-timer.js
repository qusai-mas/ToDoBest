var gHours = 0;
var gMinutes = 0;
var gSeconds = 0;

var remainingTime;

var countdownHandle;

var audio = new Audio('./sounds/beep.wav');

$(document).ready(function() {
  onPomodoroTimer();
});

function onPomodoroTimer(){

  stopTimer();

  gHours = 0;
  gMinutes = 25;
  gSeconds = 0;

  resetTimer();

  $('#shortButton').removeClass('btn-success');
  $('#longButton').removeClass('btn-success');
  $('#pomodoroButton').addClass('btn-success');
}

function on52Timer(){

  stopTimer();

  gHours = 0;
  gMinutes = 52;
  gSeconds = 0;

  resetTimer();

  $('#shortButton').removeClass('btn-success');
  $('#longButton').removeClass('btn-success');
  $('#pomodoroButton').addClass('btn-success');
}
function on17Timer(){

  stopTimer();

  gHours = 0;
  gMinutes = 17;
  gSeconds = 0;

  resetTimer();

  $('#shortButton').removeClass('btn-success');
  $('#longButton').removeClass('btn-success');
  $('#pomodoroButton').addClass('btn-success');
}
function onTockTimer(){

  stopTimer();

  gHours = 0;
  gMinutes = 45;
  gSeconds = 0;

  resetTimer();

  $('#shortButton').removeClass('btn-success');
  $('#longButton').removeClass('btn-success');
  $('#pomodoroButton').addClass('btn-success');
}

function onShortTimer(){

  stopTimer();

  gHours = 0;
  gMinutes = 5;
  gSeconds = 0;

  resetTimer();

  $('#pomodoroButton').removeClass('btn-success');
  $('#longButton').removeClass('btn-success');
  $('#shortButton').addClass('btn-success');
}

function onLongTimer(){

  stopTimer();

  gHours = 0;
  gMinutes = 15;
  gSeconds = 0;

  resetTimer();

  $('#pomodoroButton').removeClass('btn-success');
  $('#shortButton').removeClass('btn-success');
  $('#longButton').addClass('btn-success');
}
function twominrule(){

  stopTimer();

  gHours = 0;
  gMinutes = 2;
  gSeconds = 0;

  resetTimer();

  $('#pomodoroButton').removeClass('btn-success');
  $('#shortButton').removeClass('btn-success');
  $('#longButton').addClass('btn-success');
}

function onStartTimer(){
  stopTimer();
  startTimer();
};

function onStopTimer(){
  stopTimer();

};

function onResetTimer(){
  stopTimer();
  resetTimer();
}

function startAlarm(){
  if(remainingTime<1000)
  {
    audio.play();
  }
}

function startTimer() {
  countdownHandle=setInterval(function() {
    decrementTimer();
  },1000);
}

function stopTimer() {
  clearInterval(countdownHandle);
  startAlarm();

}

function resetTimer(){

  remainingTime = (gHours*60*60*1000)+
  (gMinutes*60*1000)+
  (gSeconds*1000);
  renderTimer();
}

function renderTimer(){


  var deltaTime=remainingTime;

  var hoursValue=Math.floor(deltaTime/(1000*60*60));
  deltaTime=deltaTime%(1000*60*60);

  var minutesValue=Math.floor(deltaTime/(1000*60));
  deltaTime=deltaTime%(1000*60);

  var secondsValue=Math.floor(deltaTime/(1000));

  animateTime(hoursValue, minutesValue, secondsValue);
};


function animateTime(remainingHours, remainingMinutes, remainingSeconds) {

  // position
  $('#hoursValue').css('top', '0em');
  $('#minutesValue').css('top', '0em');
  $('#secondsValue').css('top', '0em');

  $('#hoursNext').css('top', '0em');
  $('#minutesNext').css('top', '0em');
  $('#secondsNext').css('top', '0em');

  var oldHoursString = $('#hoursNext').text();
  var oldMinutesString = $('#minutesNext').text();
  var oldSecondsString = $('#secondsNext').text();

  var hoursString = formatTime(remainingHours);
  var minutesString = formatTime(remainingMinutes);
  var secondsString = formatTime(remainingSeconds);

  $('#hoursValue').text(oldHoursString);
  $('#minutesValue').text(oldMinutesString);
  $('#secondsValue').text(oldSecondsString);

  $('#hoursNext').text(hoursString);
  $('#minutesNext').text(minutesString);
  $('#secondsNext').text(secondsString);

  // set and animate
  if(oldHoursString !== hoursString) {
    $('#hoursValue').animate({top: '-=1em'});
    $('#hoursNext').animate({top: '-=1em'});
  }

  if(oldMinutesString !== minutesString) {
    $('#minutesValue').animate({top: '-=1em'});
    $('#minutesNext').animate({top: '-=1em'});
  }

  if(oldSecondsString !== secondsString) {
    $('#secondsValue').animate({top: '-=1em'});
    $('#secondsNext').animate({top: '-=1em'});
  }
}


function formatTime(intergerValue){

  return intergerValue > 9 ? intergerValue.toString():'0'+intergerValue.toString();

}

function decrementTimer(){

  remainingTime-=(1*1000);

  if(remainingTime<1000){
    onStopTimer();
  }

  renderTimer();
}

// Create a "close" button and append it to each list item
var myNodelist = document.getElementsByTagName("LI");
var i;
for (i = 0; i < myNodelist.length; i++) {
  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  myNodelist[i].appendChild(span);
}

// Click on a close button to hide the current list item
var close = document.getElementsByClassName("close");
var i;
for (i = 0; i < close.length; i++) {
  close[i].onclick = function() {
    var div = this.parentElement;
    div.style.display = "none";
  }
}

// Add a "checked" symbol when clicking on a list item
var list = document.querySelector('ul');
list.addEventListener('click', function(ev) {
  if (ev.target.tagName === 'LI') {
    ev.target.classList.toggle('checked');
  }
}, false);

// Create a new list item when clicking on the "Add" button
function newElement() {
addTodo();
  var li = document.createElement("li");
  var inputValue = document.getElementById("myInput").value;
  var t = document.createTextNode(inputValue);
  li.appendChild(t);
  if (inputValue === '') {
    alert("You must write something!");
  } else {
    document.getElementById("myUL").appendChild(li);
  }
  document.getElementById("myInput").value = "";

  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  li.appendChild(span);

  for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
      var div = this.parentElement;
      div.style.display = "none";
    }
  }
}
