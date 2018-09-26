// pages/index/index.js
Page({


  /**
   * 页面的初始数据
   */
  data: {
    one: true,
    two: true,
    three: true,
    four: true,

    list: [{
      "title": "主菜单",
      "indexone": [{
          "title": "系统设置",
          "indextwo": [{
              "title": "消息",
              "indexthree": [{
                  "title": "消息列表",
                  "indexfour": [{
                      "title": "消息详情",
                    },
                    {
                      "title": "消息功能",
                    }
                  ]
                },
                {
                  "title": "关于",
                  "indexfour": [{
                      "title": "APP介绍",
                    },
                    {
                      "title": "隐私声明",
                    }
                  ]
                }
              ]
            },
            {
              "title": "积分商城",
              "indexthree": [{
                  "title": "积分管理",
                  "indexfour": [{
                      "title": "积分增加",
                    },
                    {
                      "title": "积分减少",
                    }
                  ]
                },
                {
                  "title": "积分兑换",
                  "indexfour": [{
                      "title": "兑换增加",
                    },
                    {
                      "title": "兑换减少",
                    }
                  ]
                }
              ]
            }
          ]
        },
        {
          "title": "个人中心",
          "indextwo": [{
              "title": "个人信息",
              "indexthree": [{
                  "title": "收货地址",
                },
                {
                  "title": "生日",
                }
              ]
            },
            {
              "title": "账号同步",
              "indexthree": [{
                  "title": "删除同步",
                },
                {
                  "title": "设置同步",
                }
              ]
            }
          ]
        }
      ]
    }]
  },
  zhu: function e() {
    var that = this;
    console.log(that.data.list)
    if (that.data.two == false) {
      that.setData({
        one: (!that.data.one),
        two: (!that.data.two)
      })

      // 提示用户是否关闭下一级再关闭这一级
      // wx.showModal({
      //   title: '提示',
      //   content: '请先关闭上一级',
      //   success: function(res) {
      //     if (res.confirm) {
      //       console.log('用户点击确定')
      //       that.setData({
      //         one: (!that.data.one),
      //         two: (!that.data.two)
      //       })
      //     }

      //   }

      // })
    } else if(that.data.three == false) {
      that.setData({
        one: (!that.data.one),
        two: (!that.data.two),
        three: (!that.data.three),
      })
    }
     else {
      that.setData({
        one: (!that.data.one),
      })
    }
  },
  indexone0: function e() {
    var that = this;
    that.setData({
      two: (!that.data.two)
    })
  },
  indextwo0:function e(){
    var that = this;
    that.setData({
      three: (!that.data.three)
    })
  },


  // 页面跳转
  url:function e(){
    wx.redirectTo({
      url: '../upload/upload',
      success: function(res) {},
      fail: function(res) {},
      complete: function(res) {},
    })
  }

})