function isEmpty(s) {
	return s.trim() ? "" : "Không được để trống!\n"
}
function checkUserName(s, lenght, ErroRow) {
	if (!s.trim())
		return ErroRow+" Không được để trống!\n"
	var s1=s.trim();
	return s1.length>lenght ? "":"số ký tự của "+ErroRow+" phải lớn hơn " + lenght+"\n"
}
function confirmPassword(s1, s2){
	return s1===s2 ? "":"ConfirmPassword không trùng khớp!";
}