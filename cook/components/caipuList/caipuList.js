// components/caipuList/caipuList.js
Component({
    options: {
        styleIsolation: 'shared',
      },
    /**
     * 组件的属性列表
     */
    properties: {
        caipu:Object
    },

    /**
     * 组件的初始数据
     */
    data: {
        isloading: false,
        list:{}
    },

    /**
     * 组件的方法列表
     */
    methods: {
        onDetail(e){
        
            wx.navigateTo({
                url: `../../pages/detail/detail?id=${e.currentTarget.dataset.id}`,
              })
        },

    },
    lifetimes:{
        attached(){
        }
    }
})
