webpackJsonp([1],{45:function(t,e,i){i(48);var o=i(19)(i(47),i(51),"data-v-735e3192",null);o.options.__file="/home/diao/projects/iview-project-3.0/src/views/qiqi.vue",o.esModule&&Object.keys(o.esModule).some(function(t){return"default"!==t&&"__esModule"!==t})&&console.error("named exports are not supported in *.vue files."),o.options.functional&&console.error("[vue-loader] qiqi.vue: functional components are not supported with templates, they should use render functions."),t.exports=o.exports},47:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default={data:function(){return{upload_modal:!1,pic_modal:!1,upload_sel:1,cat_list:[],pic_list:[],big_pic_name:"",cateId:1,page_num:1,btn_show:!1,couter:0,loading_text:"加载中",clientHeight:document.documentElement.clientHeight-80}},mounted:function(){var t=this;this.$axios.get("/qiqi/queryCategory").then(function(e){t.cat_list=e.data.data}),this.queryPic(1,!1)},methods:{showPic:function(t){var e=this;this.pic_modal=!0,this.pic_list.forEach(function(i){i.id==t&&(e.big_pic_name=i.picName)})},queryPic:function(t,e){var i=this;this.$axios.get("/qiqi/queryPic?categoryId="+this.cateId+"&page="+t).then(function(t){e?0===t.data.data.length?(i.loading_text="没有更多了",i.page_num--):(i.loading_text="加载中",i.pic_list=i.pic_list.concat(t.data.data)):i.pic_list=t.data.data})},navChange:function(t){console.log(t),"0"===t?5===++this.couter&&(this.btn_show=!0):(this.cateId=t,this.queryPic(1,!1))},handleReachBottom:function(){var t=this;return new Promise(function(e){setTimeout(function(){t.page_num++,t.queryPic(t.page_num,!0),e()},2e3)})},uploadCallBack:function(t,e,i){1==t.code&&(this.upload_modal=!1,this.queryPic(1,!1))}}}},48:function(t,e){},51:function(t,e,i){t.exports={render:function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticStyle:{background:"#eee"}},[i("Menu",{attrs:{mode:"horizontal",theme:"primary","active-name":"1"},on:{"on-select":t.navChange}},[i("MenuItem",{attrs:{name:"0"}},[t._v("期期照片展")]),t._v(" "),t._l(t.cat_list,function(e){return i("MenuItem",{key:e.id,attrs:{name:e.id}},[i("Icon",{attrs:{type:"ios-paper"}}),t._v("\n      "+t._s(e.categoryDesc)+"\n    ")],1)}),t._v(" "),i("Button",{directives:[{name:"show",rawName:"v-show",value:t.btn_show,expression:"btn_show"}],staticClass:"right",on:{click:function(e){t.upload_modal=!t.upload_modal}}},[t._v("上传")])],2),t._v(" "),i("br"),t._v(" "),i("Scroll",{attrs:{"on-reach-bottom":t.handleReachBottom,height:t.clientHeight,"distance-to-edge":"","loading-text":t.loading_text}},[i("div",{staticStyle:{"text-align":"center"}},[i("Form",{attrs:{inline:""}},t._l(t.pic_list,function(e){return i("FormItem",{key:e.id},[i("Card",{staticStyle:{width:"320px"},nativeOn:{click:function(i){t.showPic(e.id)}}},[i("div",{staticStyle:{"text-align":"center"}},[i("img",{attrs:{src:e.thumbPicName,height:"200",width:"250"}})])])],1)}))],1)]),t._v(" "),i("Modal",{attrs:{title:"原图",fullscreen:"","footer-hide":""},model:{value:t.pic_modal,callback:function(e){t.pic_modal=e},expression:"pic_modal"}},[i("div",{staticClass:"scale"},[i("img",{attrs:{src:t.big_pic_name}})])]),t._v(" "),i("Modal",{attrs:{title:"上传图片","footer-hide":""},model:{value:t.upload_modal,callback:function(e){t.upload_modal=e},expression:"upload_modal"}},[i("Form",[i("FormItem",[i("Select",{staticStyle:{width:"200px"},model:{value:t.upload_sel,callback:function(e){t.upload_sel=e},expression:"upload_sel"}},t._l(t.cat_list,function(e){return i("Option",{key:e.id,attrs:{value:e.id}},[t._v(t._s(e.categoryDesc))])}))],1),t._v(" "),i("FormItem",[i("Upload",{attrs:{multiple:"",action:"/qiqi/savePicInfo",data:{categoryId:t.upload_sel},"on-success":t.uploadCallBack}},[i("Button",{attrs:{icon:"ios-cloud-upload-outline"}},[t._v("上传照片")])],1)],1)],1)],1)],1)},staticRenderFns:[]},t.exports.render._withStripped=!0}});