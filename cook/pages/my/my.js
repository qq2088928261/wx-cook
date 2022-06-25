// pages/my/my.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        status:false,
        isUserInfo: false,

        
    },
    onShareAppMessage() {
        const promise = new Promise(resolve => {
            setTimeout(() => {
                resolve({
                    title: '菜谱'
                })
            }, 2000)
        })
        return {
            title: '菜谱',
            path: '/page/user?id=123',
            promise
        }
    },

    getUserInfo: function () {
        if(this.data.status===true) return
        wx.getStorage({
            key:'isUser',
            success:res=>{
                this.setData({status:res.data})
            }
        })
        wx.getUserProfile({
            desc: '获取头像昵称',
            success: res => {
                
                this.setData({
                    isUserInfo: true,
                    status:true,
                    
                })
                wx.setStorage({
                    key:'isUser',
                    data:true
                })
                wx.setStorage({
                    key: 'username',
                    data: res.userInfo.nickName
                })
                


            }
        })


    },
    toLianXi(){
        wx.navigateTo({
            url: "/pages/contact/contact",
          })
    },
    go(){
        wx.makePhoneCall({
            phoneNumber: '15390731738' //仅为示例，并非真实的电话号码
          })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
        if(wx.getStorageSync('isUser')!=''){
        wx.getStorage({
            key:'isUser',
            success:res=>{
                this.setData({status:res.data})
            }
        })
        wx.getStorage({
            key: 'isUser',
            success: res => {
                if (res.data) {
                    this.setData({
                        isUserInfo: true,


                    })
                }
            }
        })
    }
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