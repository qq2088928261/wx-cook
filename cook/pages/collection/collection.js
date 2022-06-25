// pages/collection/collection.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        username:'',
        listId:[],
        caipu:[]
    },
    getId() {
        var that = this
        wx.request({
            url: `http://192.168.234.54:8081/getdishid?username=${that.data.username}`,
            // data: {

            // },
            header: {
                'content-type': 'application/json' // 默认值
            },
            success(res) {
                var arr=[...res.data]
                that.setData({
                    listId:[...arr] 
                })
                var th1=that
                wx.request({
                    url: `http://192.168.234.54:8081/getAllName?list=${th1.data.listId}`,
                    // data: {
        
                    // },
                    header: {
                        'content-type': 'application/json' // 默认值
                    },
                    success(res) {
                        
                        that.setData({
                            caipu: res.data
                        })
                        console.log(that.data.caipu);
                    }
        
                })
                
            }


        })

    },
    

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad() {
        var user = wx.getStorageSync('username')
        this.setData({
            username:user
        })
        
        
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
        this.getId();
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