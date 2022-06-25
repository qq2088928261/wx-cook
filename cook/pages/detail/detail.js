// pages/detail/detail.js

Page({

    /**
     * 页面的初始数据
     */
    data: {
        items: [],
        username: '',
        id: '',
        src: '',
        status: ''
    },
    getDetail(id) {
        var that = this
        wx.request({
            url: 'http://192.168.234.54:8081/getcp',
            data: {
                id: id,
            },
            header: {
                'content-type': 'application/json' // 默认值
            },
            success(res) {
                that.setData({
                    items: res.data
                })

            }

        })
    },
    onCollection() {
        this.check();
        this.getStatus();

    },
    check() {
        var that = this
        wx.request({
            url: `http://192.168.234.54:8081/findbyid?username=${that.data.username}&dishid=${that.data.id}`,
            data: {},
            header: {
                'content-type': 'application/json' // 默认值
            },
            success(res) {
                that.setData({
                    status: res.data,
                })
                if (that.data.status === false) {
                    that.setData({
                        src: "/images/_收藏1小.png"
                    })
                }
                if (that.data.status === true) {
                    that.setData({
                        src: "/images/_收藏1(1).png"
                    })
                }

            }
        })
    },
    getStatus() {
        var that = this
        console.log(this.data.username);
        console.log(this.data.id);
        if (this.data.status == false) {
            wx.request({
                url: `http://192.168.234.54:8081/collection?username=${that.data.username}&dishid=${that.data.id}`,
                data: {},
                header: {
                    'content-type': 'application/json' // 默认值
                },
                success(res) {
                    if (res.data === 0) {
                        wx.showModal({
                            title: '提示',
                            content: '是否去登录',
                            success: function (res) {
                                if (res.confirm) {
                                    wx.switchTab({
                                        url: '/pages/my/my',
                                    })

                                } else if (res.cancel) {
                                    wx.showToast({
                                      title: '无法收藏',
                                      icon:'error'
                                    })
                                }
                            }
                        })
                       
                    }
                    that.setData({
                        src: "/images/_收藏1(1).png"
                    })

                }
            })
            this.check();
        }
        if (this.data.status === true) {
            wx.request({
                url: `http://192.168.234.54:8081/delete?username=${that.data.username}&dishid=${that.data.id}`,
                data: {},
                header: {
                    'content-type': 'application/json' // 默认值
                },
                success(res) {
                    that.setData({
                        src: "/images/_收藏1小.png"
                    })
                }
            })
            this.check();

        }
    },

    /**
     * 生命周期函数--监听页面加载
     */

    onLoad(e) {
        this.getDetail(e.id);
        var user = wx.getStorageSync('username')
        this.setData({
            id: e.id,
            username: user
        })
        this.check();
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady() {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow() {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh() {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage() {

    }
})