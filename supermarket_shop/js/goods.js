var goods = new Object({
    URL: {
        BASE_URL: "http://localhost:8085/jxc/api/",
        LOGIN: function(username, password) {
            return goods.URL.BASE_URL + "user/" + username + "/" + password + "/login"
        },
        GET_GOODS: function(type, page, num) {
            return goods.URL.BASE_URL + "goods/" + page + "/" + num + "/" + type
        },
        GOODS_XIAJIA: function(token, id, type) {
            return goods.URL.BASE_URL + "goods/" + token + "/auth/" + id + "/" + type + "/down"
        },
        GET_GOODS_PAGE: function(type, num) {
            return goods.URL.BASE_URL + "goods/" + num + "/" + type + "/page"
        },
        GET_INSTOCK_PAGE: function(num) {
            return goods.URL.BASE_URL + "instock/" + num + "/page"
        },
        GET_SELL_PAGE: function(num) {
            return goods.URL.BASE_URL + "goods/" + num + "/page"
        },
        GET_NOTICE_PAGE: function(num) {
            return goods.URL.BASE_URL + "notice/" + num + "/notice"
        },
        GET_INSTOCK: function(page, num) {
            return goods.URL.BASE_URL + "instock/" + page + "/" + num + "/instock"
        },
        GET_SELL: function(page, num) {
            return goods.URL.BASE_URL + "goods/" + page + "/" + num + "/sells"
        },
        ADD_INSTOCK: function(data, token) {
            //进货时间 产品编号	数量 单价 总价
            if (data.intime == '') {
                data.intime = 'all';
            }
            if (data.id == '') {
                data.id = 'all';
            }
            if (data.num == '') {
                data.num = 'all';
            }
            if (data.price == '') {
                data.price = 'all';
            }
            $("#goods_allprice").val($("#goods_num").val() * $("#goods_price").val());
            return goods.URL.BASE_URL + "instock/" + token + "/auth/" + data.intime + "/" + data.id + "/" + data.num + "/" + data.price + "/add"
        },
        SEARCH_INSTOCK: function(data, page, num) {
            //进货时间 产品编号	数量 单价 总价
            if (data.intime == '') {
                data.intime = 'all';
            }
            if (data.id == '') {
                data.id = 'all';
            }
            if (data.num == '') {
                data.num = 'all';
            }
            if (data.price == '') {
                data.price = 'all';
            }
            if (data.allprice == '') {
                data.allprice = 'all';
            }
            return goods.URL.BASE_URL + "instock/search/" + data.intime + "/" + data.id + "/" + data.num + "/" + data.price + "/" + data.allprice + "/" + page + "/" + num + "/instock"
        },
        SEARCH_SELL: function(data, page, num) {
            //销售时间 产品编号	数量 单价 总价	
            if (data.outtime == '') {
                data.outtime = 'all';
            }
            if (data.id == '') {
                data.id = 'all';
            }
            if (data.num == '') {
                data.num = 'all';
            }
            if (data.price == '') {
                data.price = 'all';
            }
            if (data.allprice == '') {
                data.allprice = 'all';
            }
            return goods.URL.BASE_URL + "sell/search/" + data.outtime + "/" + data.id + "/" + data.num + "/" + data.price + "/" + data.allprice + "/" + page + "/" + num + "/sell"

        },
        SEARCH_GOODS: function(type, data, page, num) {
            if (type == 'foods') {
                //名称 品牌 截止日期 产地 价格 数量
                if (data.name == '') {
                    data.name = 'all';
                }
                if (data.pingpai == '') {
                    data.pingpai = 'all';
                }
                if (data.date == '') {
                    data.date = 'all';
                }
                if (data.chandi == '') {
                    data.chandi = 'all';
                }
                if (data.price_s == '') {
                    data.price_s = 'all';
                }
                if (data.price_b == '') {
                    data.price_b = 'all';
                }
                if (data.num_s == '') {
                    data.num_s = 'all';
                }
                if (data.num_b == '') {
                    data.num_b = 'all';
                }
                return goods.URL.BASE_URL + "goods/search/" + data.name + "/" + data.pingpai + "/" + data.date + "/" + data.chandi + "/" + data.price_s + "/" + data.price_b + "/" + data.num_s + "/" + data.num_b + "/" + page + "/" + num + "/foods"
            } else {
                //名称 品牌	颜色 大小 适合人群 价格 数量	
                if (data.name == '') {
                    data.name = 'all';
                }
                if (data.pingpai == '') {
                    data.pingpai = 'all';
                }
                if (data.color == '') {
                    data.color = 'all';
                }
                if (data.size == '') {
                    data.size = 'all';
                }
                if (data.person == '') {
                    data.person = 'all';
                }
                if (data.price_s == '') {
                    data.price_s = 'all';
                }
                if (data.price_b == '') {
                    data.price_b = 'all';
                }
                if (data.num_s == '') {
                    data.num_s = 'all';
                }
                if (data.num_b == '') {
                    data.num_b = 'all';
                }
                return goods.URL.BASE_URL + "goods/search/" + data.name + "/" + data.pingpai + "/" + data.color + "/" + data.size + "/" + data.person + "/" + data.price_s + "/" + data.price_b + "/" + data.num_s + "/" + data.price_b + "/" + page + "/" + num + "/clothes"
            }
        },
        GET_NOTICE: function(page, num) {
            return goods.URL.BASE_URL + "notice/" + page + "/" + num + "/notice"
        }
    },
    Init: {
        init: function() {
            var username = Cookie.getCookie("username");
            var level = Cookie.getCookie("level");
            console.log("username_cookie:", username);
            console.log("level_cookie:", level);
            var ll = '';
            switch (level) {
                case '0':
                    ll = '采购部门';
                    break;
                case '1':
                    ll = '管理部门';
                    break;
                default:
                    ll = '管理员';
                    break;
            }
            $("#user_name").html("[" + ll + "] " + username);
        }
    },
    Operate: {
        Login: function(username, password) {
            goods.Init.init();
            $.get(goods.URL.LOGIN(username, password), {}, function(data, status) {
                if (status) {
                    goods.View.Login(data);
                } else {
                    return 0;
                }
            });
        },
        GetFoodsMaxPage: function(page_num) {
            goods.Init.init();
            $.get(goods.URL.GET_GOODS_PAGE("foods", page_num), {}, function(data, status) {
                if (status) {
                    console.log(data.data);
                    $("#allpage").val(data.data);
                } else {
                    return 0;
                }
            });
        },
        GetClothesMaxPage: function(page_num) {
            goods.Init.init();
            $.get(goods.URL.GET_GOODS_PAGE("clothes", page_num), {}, function(data, status) {
                if (status) {
                    console.log(data.data);
                    $("#allpage").val(data.data);
                } else {
                    return 0;
                }
            });
        },
        GetFoods: function(page, num) {
            goods.Init.init();
            $.get(
                goods.URL.GET_GOODS("foods", page, num), {},
                function(d, status) {
                    if (status) {
                        goods.View.GetFoods(d);
                    } else {
                        var dd = Object({ status: false, msg: "oooooops~服务器开小差了！！！" });
                        goods.View.GET_GOODS(dd);
                    }
                }
            );
        },
        GetClothes: function(page, num) {
            goods.Init.init();
            $.get(
                goods.URL.GET_GOODS("clothes", page, num), {},
                function(d, status) {
                    if (status) {
                        goods.View.GetClothes(d);
                    } else {
                        var dd = Object({ status: false, msg: "ooooooops~服务器开小差了！！！" });
                        goods.View.GetClothes(dd);
                    }
                }
            );
        },
        GetInstock: function(page, num) {
            goods.Init.init();
            $.get(
                goods.URL.GET_INSTOCK(page, num), {},
                function(d, status) {
                    if (status) {
                        goods.View.GetInstock(d);
                    } else {
                        var dd = Object({ status: false, msg: "ooooooops~服务器开小差了！！！" });
                        goods.View.GetInstock(dd);
                    }
                }
            );
        },
        AddInstock: function() {
            goods.Init.init();
            var data = new Object({
                intime: $("#goods_intime").val(),
                id: $("#goods_id").val(),
                num: $("#goods_num").val(),
                price: $("#goods_price").val()
            });
            $.get(goods.URL.ADD_INSTOCK(data, Cookie.getCookie("token")), {},
                function(d, status) {
                    if (status) {
                        console.log(d);
                        console.log(d.status);
                        goods.View.AddInstock(d);
                    } else {
                        var dd = Object({ status: false, msg: "ooooooops~服务器开小差了！！！" });
                    }
                }
            );
        },
        XiaJia: function(id, type) {
            $.get(goods.URL.GOODS_XIAJIA(Cookie.getCookie("token"), id, type), {}, function(data, status) {
                if (status) {
                    goods.View.GoodsXiaJia(data);
                } else {
                    var dd = Object({ status: false, msg: "ooooooops~服务器开小差了！！！" });
                }
            });
        },
        SearchInstock: function(data, page, num) {
            goods.Init.init();
            var data = new Object({
                intime: "",
                id: "",
                num: "",
                price: "",
                allprice: ""
            });
            $.get(
                goods.URL.SEARCH_INSTOCK(data, page, num), {},
                function(d, status) {
                    if (status) {
                        goods.View.GetInstock(d);
                    } else {
                        var dd = Object({ status: false, msg: "ooooooops~服务器开小差了！！！" });
                        goods.View.GetInstock(dd);
                    }
                }
            );
        },
        GetSell: function(page, num) {
            goods.Init.init();
            $.get(
                goods.URL.GET_SELL(page, num), {},
                function(d, status) {
                    if (status) {
                        goods.View.GetSell(d);
                    } else {
                        var dd = Object({ status: false, msg: "ooooooops~服务器开小差了！！！" });
                        goods.View.GetSell(dd);
                    }
                }
            );
        },
        SearchSell: function(data, page, num) {
            goods.Init.init();
            var data = new Object({
                outtime: "",
                id: "",
                num: "",
                price: "",
                allprice: ""
            });
            $.get(
                goods.URL.SEARCH_SELL(data, page, num), {},
                function(d, status) {
                    if (status) {
                        goods.View.GetSell(d);
                    } else {
                        var dd = Object({ status: false, msg: "ooooooops~服务器开小差了！！！" });
                        goods.View.GetSell(dd);
                    }
                }
            );
        },
        SearchGoods: function() {
            goods.Init.init();
            var data = new Object({
                name: "",
                pingpai: "",
                date: "",
                chandi: "",
                price: "",
                num: ""
            });
            $.get(
                goods.URL.SEARCH_GOODS("foods", data, page, num), {},
                function(d, status) {
                    if (status) {
                        goods.View.GetFoods(d);
                    } else {
                        var dd = Object({ status: false, msg: "oooooops~服务器开小差了！！！" });
                        goods.View.GetFoods(dd);
                    }
                }
            );
        },
        SearchClothes: function(page, num) {
            goods.Init.init();
            var data = new Object({
                name: $("#c_name").val(),
                pingpai: $("#c_pingpai").val(),
                color: $("#c_color").val(),
                size: $("#c_size").val(),
                person: $("#c_older").val(),
                price_s: $("#c_price_s").val(),
                price_b: $("#c_price_b").val(),
                num_s: $("#c_num_s").val(),
                num_b: $("#c_num_b").val(),
                page: page,
                num: num
            });
            $.get(
                goods.URL.SEARCH_GOODS("clothes", data, page, num), {},
                function(d, status) {
                    if (status) {
                        goods.View.GetClothes(d);
                    } else {
                        var dd = Object({ status: false, msg: "oooooops~服务器开小差了！！！" });
                        goods.View.GetClothes(dd);
                    }
                }
            );
        },
        GetNotice: function(page, num, type) {
            goods.Init.init();
            $.get(
                goods.URL.GET_NOTICE(page, num), {},
                function(d, status) {
                    if (status) {
                        switch (type) {
                            case 'caigou':
                                goods.View.GetNoticeC(d);
                                break;
                            case 'xiajia':
                                goods.View.GetNoticeX(d);
                                break;
                            default:
                                goods.View.GetNotice(d);
                                break;
                        }

                    } else {
                        var dd = Object({ status: false, msg: "ooooooops~服务器开小差了！！！" });
                        goods.View.GetInstock(dd);
                    }
                }
            );
        },
        GetInstockMaxPage: function(page_num) {
            goods.Init.init();
            $.get(goods.URL.GET_INSTOCK_PAGE(page_num), {}, function(data, status) {
                if (status) {
                    console.log(data.data);
                    $("#allpage").val(data.data);
                } else {
                    return 0;
                }
            });
        },
        GetSellMaxPage: function(page_num) {
            goods.Init.init();
            $.get(goods.URL.GET_SELL_PAGE(page_num), {}, function(data, status) {
                if (status) {
                    console.log(data.data);
                    $("#allpage").val(data.data);
                } else {
                    return 0;
                }
            });
        },
        GetNoticeMaxPage: function(page_num) {
            goods.Init.init();
            $.get(goods.URL.GET_NOTICE_PAGE(page_num), {}, function(data, status) {
                if (status) {
                    console.log(data.data);
                    $("#allpage").val(data.data);
                } else {
                    return 0;
                }
            });
        },
    },
    View: {
        Login: function(data) {
            console.log(data);
            if (data.status == false) {
                var tip = $("<span style='display:none;color:#ff2222;' class='glyphicon glyphicon-remove'>" + data.msg + "或密码错误！</span>");
                $("#tip").html(tip)
                tip.fadeIn(800);
            } else {
                Cookie.addCookie('id', data.data.id, 72);
                Cookie.addCookie('token', data.data.token, 72);
                Cookie.addCookie('username', data.data.username, 72);
                Cookie.addCookie('level', data.data.level, 72);
                console.log(Cookie.getCookie("username"));
                window.location.href = "index.html";
            }
        },
        GetFoods: function(data) {
            console.log(data);
            if (data.data != null) {
                $.each(data.data, function(key, value) {
                    var tr = $('<tr style="display:none;"><' +
                        'td> ' + value.id + ' </td> <' +
                        'td> ' + value.name + ' </td> <' +
                        'td> ' + value.pingpai + ' </td> <' +
                        'td> ' + value.baozhiqi + ' </td> <' +
                        'td> ' + value.chandi + ' </td> <' +
                        'td> ' + value.price + ' </td> <' +
                        'td> ' + value.num + ' </td> <' +
                        'td>' +
                        '<' +
                        'a> &nbsp; &nbsp; <a href="javascript:goods.Operate.XiaJia(' + value.id + ',\'foods\');"> <span class = "glyphicon glyphicon-circle-arrow-down"> </span>下架</a> </td> <' +
                        '/tr>');
                    $("#goods_container").append(tr);
                    tr.fadeIn(800);
                });
            }

        },
        GetClothes: function(data) {
            console.log(data);
            if (data.data != null) {
                $.each(data.data, function(key, value) {
                    var tr = $('<tr style="display:none;"><' +
                        'td> ' + value.id + ' </td> <' +
                        'td> ' + value.name + ' </td> <' +
                        'td> ' + value.pingpai + ' </td> <' +
                        'td> ' + value.color + ' </td> <' +
                        'td> ' + value.size + ' </td> <' +
                        'td> ' + value.person + ' </td> <' +
                        'td> ' + value.price + ' </td> <' +
                        'td> ' + value.num + ' </td> <' +
                        'td>' +
                        '<' +
                        'a> &nbsp; &nbsp; <a href="javascript:goods.Operate.XiaJia(' + value.id + ',\'clothes\');"> <span class = "glyphicon glyphicon-circle-arrow-down"> </span>下架</a> </td> <' +
                        '/tr>');
                    $("#goods_container").append(tr);
                    tr.fadeIn(800);
                });
            } else {
                console.log("没有更多数据了");
            }
        },
        GetInstock: function(data) {
            console.log(data);
            if (data.data != null) {
                $.each(data.data, function(key, value) {
                    var tr = $('<tr style="display:none;"><' +
                        'td> ' + value.id + ' </td> <' +
                        'td> ' + value.intime + ' </td> <' +
                        'td> ' + value.gid + ' </td> <' +
                        'td> ' + value.num + ' </td> <' +
                        'td> ' + value.price + ' </td> <' +
                        'td> ' + value.allprice + ' </td> <' +
                        'td>' +
                        '<' +
                        'a> &nbsp; &nbsp; <a href="' + value + '"> <span class = "glyphicon glyphicon-eye-open"> </span>查看</a> </td> <' +
                        '/tr>');
                    $("#goods_container").append(tr);
                    tr.fadeIn(800);
                });
            } else {
                console.log("没有更多数据了");
            }
        },
        AddInstock: function(data) {
            if (data.status == true) {

                layer.open({
                    type: 1,
                    offset: 't' //具体配置参考：offset参数项
                        ,
                    content: '<div style="padding: 20px 80px;">添加成功</div>',
                    btn: 'OK',
                    btnAlign: 'c' //按钮居中
                        ,
                    shade: 0 //不显示遮罩
                        ,
                    yes: function() {
                        layer.closeAll();
                        window.location.href = "instock.html"; //此处应该局部刷新而不是刷页面
                    }
                });
            } else {
                layer.open({
                    type: 1,
                    offset: 't' //具体配置参考：offset参数项
                        ,
                    content: '<div style="padding: 20px 80px;">添加失败</div>',
                    btn: 'OK',
                    btnAlign: 'c' //按钮居中
                        ,
                    shade: 0 //不显示遮罩
                        ,
                    yes: function() {
                        layer.closeAll();
                    }
                });
            }
        },
        GoodsXiaJia: function(data) {
            if (data.status == true) {
                layer.open({
                    type: 1,
                    offset: 't' //具体配置参考：offset参数项
                        ,
                    content: '<div style="padding: 20px 80px;">下架成功！</div>',
                    btn: 'OK',
                    btnAlign: 'c' //按钮居中
                        ,
                    shade: 0 //不显示遮罩
                        ,
                    yes: function() {
                        layer.closeAll();
                        window.location.reload(); //此处应该局部刷新而不是刷页面
                    }
                });

            } else {
                layer.open({
                    type: 1,
                    offset: 't' //具体配置参考：offset参数项
                        ,
                    content: '<div style="padding: 20px 80px;">' + data.msg + '</div>',
                    btn: 'OK',
                    btnAlign: 'c' //按钮居中
                        ,
                    shade: 0 //不显示遮罩
                        ,
                    yes: function() {
                        layer.closeAll();
                        window.location.reload(); //此处应该局部刷新而不是刷页面
                    }
                });
            }
        },
        GetSell: function(data) {
            console.log(data);
            if (data.data != null) {
                $.each(data.data, function(key, value) {
                    var tr = $('<tr style="display:none;"><' +
                        'td> ' + value.id + ' </td> <' +
                        'td> ' + value.selltime + ' </td> <' +
                        'td> ' + value.gid + ' </td> <' +
                        'td> ' + value.num + ' </td> <' +
                        'td> ' + value.price + ' </td> <' +
                        'td> ' + value.allprice + ' </td> <' +
                        'td>' +
                        '<' +
                        'a> &nbsp; &nbsp; <a href="' + value + '"> <span class = "glyphicon glyphicon-eye-open"> </span>查看</a> </td> <' +
                        '/tr>');
                    $("#goods_container").append(tr);
                    tr.fadeIn(800);
                });
            } else {
                console.log("没有更多数据了");
            }
        },
        SearchGoods: function() {

        },
        SearchClothes: function() {

        },
        GetNotice: function(data) {
            console.log(data);
            if (data.data != null) {
                $.each(data.data, function(key, value) {
                    var cc = value.type == 1 ? ' 下架通知' : ' 缺货通知';
                    var tr = $(' <div class="col-md-12" style="border-bottom:dotted 1px #eee;">' +
                        '<a>' +
                        '<p>[系统生成:' + cc + '] ' + value.content + '</p>' +
                        '</a>' +
                        '<span>' + value.ctime + '</span>' +
                        '</div>');
                    $("#goods_container").append(tr);
                    tr.fadeIn(800);
                });
            } else {
                console.log("没有更多数据了");
            }
        },
        GetNoticeC: function(data) {
            console.log(data);
            if (data.data != null) {
                $.each(data.data, function(key, value) {
                    var cc = value.type == 1 ? ' 下架通知' : ' 缺货通知';
                    if (value.type == 1) {
                        var tr = $(' <div class="col-md-12" style="border-bottom:dotted 1px #eee;">' +
                            '<a>' +
                            '<p>[系统生成:' + cc + '] ' + value.content + '</p>' +
                            '</a>' +
                            '<span>' + value.ctime + '</span>' +
                            '</div>');
                        $("#goods_container").append(tr);
                        tr.fadeIn(800);
                    }
                });
            } else {
                console.log("没有更多数据了");
            }
        },
        GetNoticeX: function(data) {
            console.log(data);
            if (data.data != null) {
                $.each(data.data, function(key, value) {
                    var cc = value.type == 1 ? ' 下架通知' : ' 缺货通知';
                    if (value.type == 2) {
                        var tr = $(' <div class="col-md-12" style="border-bottom:dotted 1px #eee;">' +
                            '<a>' +
                            '<p>[系统生成:' + cc + '] ' + value.content + '</p>' +
                            '</a>' +
                            '<span>' + value.ctime + '</span>' +
                            '</div>');
                        $("#goods_container").append(tr);
                        tr.fadeIn(800);
                    }
                });
            } else {
                console.log("没有更多数据了");
            }
        }
    },
    Utils: {

    }
});