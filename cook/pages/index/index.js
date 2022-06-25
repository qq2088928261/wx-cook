// import { createStoreBindings } from 'mobx-miniprogram-bindings'
// import { store } from "../../store/store";
Page({

    /**
     * 页面的初始数据
     */
    data: {
        listData:[],
        caipu:[]
        
    },
    getByList() {
        var that = this
        wx.request({
            url: 'http://192.168.234.54:8081/getHomePageData',
            // data: {

            // },
            header: {
                'content-type': 'application/json' // 默认值
            },
            success(res) {
                that.setData({
                    listData: res.data,
                    caipu:res.data.caipu
                })
                console.log(that.data.listData);
            }

        })

    },
    




    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (option) {
        this.getByList();
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
    onUnload() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {
        // const child=this.selectComponent('.caipu-list')
        // console.log(child.data.listData.caipu);
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