var util = require("../../utils/util.js")
Page({




  data: {
    list: '',
    upload_picture_list: []
  },
  //选择图片方法
  uploadpic: function(e) {
    var that = this //获取上下文
    var upload_picture_list = that.data.upload_picture_list
    //选择图片
    wx.chooseImage({
      count: 8,
      sizeType: ['compressed'],
      sourceType: ['album', 'camera'],
      success: function(res) {
        var tempFiles = res.tempFiles
        //把选择的图片 添加到集合里
        for (var i in tempFiles) {
          tempFiles[i]['upload_percent'] = 0
          tempFiles[i]['path_server'] = ''
          upload_picture_list.push(tempFiles[i])
        }
        //显示
        that.setData({
          upload_picture_list: upload_picture_list,
        });
      }
    })
  },
  //点击上传事件
  uploadimage: function() {
    var page = this
    var upload_picture_list = page.data.upload_picture_list
    var url = "http://localhost:8080/upload/file";   
   // var url = "http://www.lovevivian.com:8080/openid/upload/file"; //服务器地址
    // console.log(upload_picture_list.length);
    //循环把图片上传到服务器 并显示进度
    for (var j in upload_picture_list) {
      if (upload_picture_list[j]['upload_percent'] == 0) {　　　　　　 //调用函数

        util.upload(url, page, upload_picture_list, j)
      }
      console.log("上传成功")
    }

  },

  // 删除图片
  deleteImg: function(e) {
    let upload_picture_list = this.data.upload_picture_list;
    let index = e.currentTarget.dataset.index;
    upload_picture_list.splice(index, 1);
    this.setData({
      upload_picture_list: upload_picture_list
    });
  },

  // 页面跳转
  url: function e() {
    wx.redirectTo({
      url: '../list/list',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
  }
})