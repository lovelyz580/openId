// pages/user/user.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    body:" "
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      body: '用户'
    })
  },
  user:function e(){
console.log("用户")
this.setData({
  body :'用户'
})
  },
  admin:function e(){
    console.log("管理员")
    this.setData({
      body: '管理员'
    })
  },
  order:function e(){
    console.log("商家")
    this.setData({
      body: '商家'
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})