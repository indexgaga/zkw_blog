$(function () {
    var flag_nickname = false;
    var flag_username = false;
    var flag_password = false;
    var flag_password2 = false;

    //昵称合法检测
    $("#user_nickname").on("change", function () {
        var user_nickname = $("#user_nickname").val();
        if (user_nickname.length < 2) {
            $("#user_nickname_div").attr("class", "form-group has-error");
            $("#user_nickname_msg").remove();
            $("#user_nickname_div").append("<span id=user_nickname_msg style='color:red'>昵称太短</span>");
            flag_nickname = false;
        } else {
            $("#user_nickname_div").attr("class", "form-group has-success");
            $("#user_nickname_msg").remove();
            flag_nickname = true;
        }
    })

    //账号合法检测
    $("#user_name").on("change", function () {
        var user_name = $("#user_name").val();
        var reg = /^\d{4,15}$/;
        if (reg.test(user_name) == false) {
            $("#user_name_div").attr("class", "form-group has-error");
            $("#user_name_msg").remove();
            $("#user_name_div").append("<span id=user_name_msg style='color:red'>账号不能太短，且只能是数字哦</span>");
            flag_username = false;
        } else {
            $("#user_name_div").attr("class", "form-group has-success");
            $("#user_name_msg").remove();
            flag_username = true;
        }
    })

    //密码合法检测
    $("#user_password").on("change", function () {
        var user_password = $("#user_password").val();

        //重复密码检测
        var user_password2 = $("#user_password2").val();
        if (user_password!=user_password2) {
            $("#user_password2_div").attr("class", "form-group has-error");
            $("#user_password2_msg").remove();
            $("#user_password2_div").append("<span id=user_password2_msg style='color:red'>密码不一致</span>");
            flag_password2 = false;
        } else {
            $("#user_password2_div").attr("class", "form-group has-success");
            $("#user_password2_msg").remove();
            flag_password2 = true;
        }

        var reg = /^[\w]{6,15}$/;
        if (reg.test(user_password) == false) {
            $("#user_password_div").attr("class", "form-group has-error");
            $("#user_password_msg").remove();
            $("#user_password_div").append("<span id=user_password_msg style='color:red'>长度为6~15,密码可以由字母、数字、_、组成，</span>");
            flag_password = false;
        } else {
            $("#user_password_div").attr("class", "form-group has-success");
            $("#user_password_msg").remove();
            flag_password = true;
        }
    })

    //重复密码检测
    $("#user_password2").on("change", function () {
        var user_password = $("#user_password").val();
        var user_password2 = $("#user_password2").val();

        if (user_password!=user_password2) {
            $("#user_password2_div").attr("class", "form-group has-error");
            $("#user_password2_msg").remove();
            $("#user_password2_div").append("<span id=user_password2_msg style='color:red'>密码不一致</span>");
            flag_password2 = false;
        } else {
            $("#user_password2_div").attr("class", "form-group has-success");
            $("#user_password2_msg").remove();
            flag_password2 = true;
        }
    })

    var mysubmit=document.getElementById('registBut');
    mysubmit.onclick=function(event){
        if(flag_nickname && flag_username && flag_password && flag_password2){
            
        }else{
            event.preventDefault();
        }
    }


})

//字符类别判断
function CharMode(iN) {
    if (iN >= 48 && iN <= 57) //数字
        return 1;
    if (iN >= 65 && iN <= 90) //大写字母
        return 2;
    if (iN >= 97 && iN <= 122) //小写字母
        return 4;
    else
        return 8; //特殊字符
}

//bitTotal函数
//计算当前密码中有多少种模式
function bitTotal(num) {
    modes = 0;
    for (i = 0; i < 4; i++) {
        if (num & 1) modes++;
        num >>>= 1;
    }
    return modes;
}

//checkStrong函数
//返回密码强度级别
function checkStrong(sPW) {
    if (sPW.length <= 4)
        return 0; //密码太短
    Modes = 0;
    for (i = 0; i < sPW.length; i++) {
        //测试每一个字符类别并统计有多少种模式.
        Modes |= CharMode(sPW.charCodeAt(i));
    }
    return bitTotal(Modes);
}

//pwStrength函数
//当密码框失去焦点时,根据不同级别显示不同颜色
function pwStrength(pwd) {
    O_color = "#eeeeee";
    L_color = "#FF0000";
    M_color = "#FF9900";
    H_color = "#33CC00";
    if (pwd == null || pwd == '') {
        Lcolor = Mcolor = Hcolor = O_color;
    }
    else {
        S_level = checkStrong(pwd);
        switch (S_level) {
            case 0:
                Lcolor = Mcolor = Hcolor = O_color;
            case 1:
                Lcolor = L_color;
                Mcolor = Hcolor = O_color;
                break;
            case 2:
                Lcolor = Mcolor = M_color;
                Hcolor = O_color;
                break;
            default:
                Lcolor = Mcolor = Hcolor = H_color;
        }
    }
    document.getElementById("strength_L").style.background = Lcolor;
    document.getElementById("strength_M").style.background = Mcolor;
    document.getElementById("strength_H").style.background = Hcolor;
    return;
}