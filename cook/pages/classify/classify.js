// pages/classify/classify.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        items:[],
        mainActiveIndex: 0,
        activeId: null,
        id:''
    },
    onClickNav({
        detail = {}
    }) {
        this.setData({
            mainActiveIndex: detail.index || 0,
        });
        console.log(this.data.mainActiveIndex);
    },

    onClickItem({
        detail = {}
    }) {
        // const activeId = this.data.activeId === detail.id ? null : detail.id;
        this.setData({
            activeId: detail.id
        });
        console.log(this.data.activeId);
        this.setData({
            id:this.data.activeId
        })
        
       var that=this
       
       
        wx.navigateTo({
            url: `/pages/detail/detail?id=${that.data.id}`,
        })

    },
    getList() {
        var that = this
        wx.request({
            url: 'http://192.168.234.54:8081/getAllDish',
            // data: {

            // },
            header: {
                'content-type': 'application/json' // 默认值
            },
            success(res) {
                that.setData({
                    items: res.data
                })
                console.log(that.data.items);
            }

        })

    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
        this.getList()
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