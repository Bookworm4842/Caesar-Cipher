var alphabet = "abcdefghijklmnopqrstuvwxyz";
var allAlphabet = alphabet + alphabet + alphabet;

function runCipher(){
  var cipherText = $('#cypher').val();
  var cipherOffset = $('#offset').val();
  cipherOffset = (cipherOffset % alphabet.length);
  var cipherFinish = '';

  for(i=0; i<cipherText.length; i++){
     var letter = cipherText[i];
     var upper = (letter == letter.toUpperCase());
     letter = letter.toLowerCase();
    
     var index = alphabet.indexOf(letter);
     if(index == -1){
       cipherFinish += letter;
     } else {
       index = ((index + cipherOffset) + alphabet.length);
       var nextLetter = allAlphabet[index];
       if(upper) nextLetter = nextLetter.toUpperCase();
       cipherFinish += nextLetter;
     }
     
 runCipher();
<br/>
