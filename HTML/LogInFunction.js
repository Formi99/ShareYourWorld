    function validazioneLogIn(){
        var usernameApp = document.getElementById ('txtusn').value;
        var passwordApp = document.getElementById ('txtpsw').value;
        if ( usernameApp.length >3 && passwordApp.length >7 && passwordApp!=usernameApp ){
            alert ("LogIn succesful");
    
        }else{
            alert ("LogIn failed");
        }   
    }
    //window.onload = validazioneLogIn;
