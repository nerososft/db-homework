//cookies 处理函数
var Cookie = new Object({
    addCookie: function(name, value, expiresHours) {
        var setcookie = name + "=" + encodeURI(value);
        if (expiresHours > 0) {
            var curdate = new Date();
            curdate.setTime(curdate.getTime() + expiresHours * 3600 * 1000);
            setcookie = setcookie + ";expires=" + curdate.toGMTString()
        }
        setcookie = setcookie + ";path=/";
        document.cookie = setcookie;
        return true;
    },

    getCookie: function(name) {
        var strcookie = document.cookie;
        var arrcookie = strcookie.split(";");
        for (var i = 0; i < arrcookie.length; i++) {
            var arr = arrcookie[i].split("=");
            arr[0] = arr[0].trim();
            if (arr[0] == name) {
                return decodeURI(arr[1])
            }
        };
        return "";
    },
    deleteCookie: function(name) {
        var curdate = new Date();
        curdate.setTime(curdate.getTime() - 10000);
        document.cookie = name + "=eg;expires=" + curdate.toGMTString() + ";path=/"
    },
    deleteAllCookie: function() {
        var curdate = new Date();
        curdate.setTime(curdate.getTime() - 10000);
        var delcookies = document.cookie;
        var arrcookies = delcookies.split(";");
        for (var i = 0; i < arrcookies.length; i++) {
            var arr = arrcookies[i].split("=");
            document.cookie = arr[0] + "=eg;expires=" + curdate.toGMTString() + ";path=/"
        }
    }
});