(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/index/index"],{1145:function(t,e,a){"use strict";a.r(e);var i=a("86b3"),s=a.n(i);for(var n in i)"default"!==n&&function(t){a.d(e,t,function(){return i[t]})}(n);e["default"]=s.a},"1e33":function(t,e,a){"use strict";a("15bb");var i=n(a("b0ce")),s=n(a("a894"));function n(t){return t&&t.__esModule?t:{default:t}}Page((0,i.default)(s.default))},"4e65":function(t,e,a){"use strict";var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("view",{staticClass:"index"},[t._m(0),a("scroll-view",{staticClass:"msg_container",attrs:{"scroll-y":!0}},t._l(t.msgList,function(e,i){return a("view",{key:i,staticClass:"msg_list",attrs:{eventid:"371817f1-0-"+i},on:{click:function(a){t.goDetail(e)}}},[a("view",{staticClass:"msg_title"},[a("view",{staticClass:"title_child"},[a("view",[a("image",{staticClass:"time_icon",attrs:{src:"../../static/icon/time.png"}})]),a("view",{staticClass:"word"},[t._v(t._s(e.time))])]),a("view",{staticClass:"title_child"},[a("view",[a("image",{staticClass:"location_icon",attrs:{src:"../../static/icon/location.png"}})]),a("view",{staticClass:"word"},[t._v(t._s(e.location))])])]),a("view",{staticClass:"msg_img_container"},[a("image",{staticClass:"msg_img",attrs:{src:e.imgUrl}})]),a("view",{staticClass:"btn_detail"},[t._v("详细")])])}))],1)},s=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("view",{staticClass:"pi_camera"},[a("video",{attrs:{src:"http://live.bearboy.tech/pi_app/pi_stream.m3u8?auth_key=1553662055-0-0-fe00918194afd3ca7970155d3a950869"}})])}];a.d(e,"a",function(){return i}),a.d(e,"b",function(){return s})},"62b5":function(t,e,a){},"86b3":function(t,e,a){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a={data:function(){return{msgList:[{imgUrl:"https://bearboy.tech/oppo/photos/20190131140225.jpg",time:"13:20:21",location:"地球",text:"黑龙江饺子馆",target:"饭店;人;",msg:"暂无"}]}},onLoad:function(){this.getList(),this.getData()},methods:{getList:function(){var e=this.msgList,a=new Date;t.request({url:"http://www.bearboy.tech/oppo/GetMsgServlet",method:"POST",data:{today:a.getFullYear()+"-"+(a.getMonth()+1)+"-"+a.getDate()},header:{"content-type":"application/x-www-form-urlencoded"},success:function(t){200==t.statusCode&&(t.data.forEach(function(t){e.unshift(t)}),console.log(e))}})},goDetail:function(e){t.navigateTo({url:"/pages/msg/msg?time="+e.time+"&location="+e.location+"&imgUrl="+e.imgUrl+"&target="+e.target+"&text="+e.text+"&msg="+e.msg})},getData:function(){var t=this.msgList;if("undefined"!==typeof EventSource){console.log("yes");var e=new EventSource("http://www.bearboy.tech/oppo/SSEServlet");e.onmessage=function(e){console.log(JSON.parse(e.data)),t.unshift(JSON.parse(e.data))}}}}};e.default=a}).call(this,a("649d")["default"])},"8abf":function(t,e,a){"use strict";var i=a("62b5"),s=a.n(i);s.a},a894:function(t,e,a){"use strict";a.r(e);var i=a("4e65"),s=a("1145");for(var n in s)"default"!==n&&function(t){a.d(e,t,function(){return s[t]})}(n);a("8abf");var o=a("2877"),c=Object(o["a"])(s["default"],i["a"],i["b"],!1,null,null,null);e["default"]=c.exports}},[["1e33","common/runtime","common/vendor"]]]);