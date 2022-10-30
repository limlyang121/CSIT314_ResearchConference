

$(document).ready(function() {
	document.getElementById ("confirmation").addEventListener ("click", confirmUserAction, true);
})


function loginValidationCheck() {
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var usernameVal = username.value.trim();
    var passwordVal = password.value;
    var canSubmit = true;

    if (usernameVal === '' || usernameVal === null) {
        setFail(username, 'Username cannot be empty');
        canSubmit = false;
    } else if (!usernameLengthValid(usernameVal)) {
        setFail(username, 'Username cannot be longer than 45 characters');
        canSubmit = false;
    } else if (!usernameFormatValid(usernameVal)) {
        setFail(username, 'Username can only contain lowercase letters, numbers, dots and underscore');
        canSubmit = false;
    } else {
        setPass(username);
        username.value = usernameVal;
    }

    if (passwordVal === '' || passwordVal === null) {
        setFail(password, 'Password cannot be empty');
        canSubmit = false;
    } else if (!passwordLengthValid(passwordVal)) {
        setFail(password, 'Password cannot be longer than 45 characters');
        canSubmit = false;
    } else if (!passwordFormatValid(passwordVal)) {
        setFail(password, 'Password cannot contain spaces');
        canSubmit = false;
    } else {
        setPass(password);
    }
    return canSubmit;
}

function logout2() {
	return confirm("Are you sure want to log out?");
}  

function confirmUserAction (message){
	return confirm(message);
}
