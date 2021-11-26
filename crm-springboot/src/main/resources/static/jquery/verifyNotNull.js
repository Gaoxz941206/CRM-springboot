function verifyNotNull(string) {
    if(string !== null && string !== "" && typeof(string) !== "undefined"){
        return true;
    }else return false;
}