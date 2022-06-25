// components/swiper/swiper.js

Component({
    /**
     * 组件的属性列表
     */
    properties: {
        listData:Object
    },

    /**
     * 组件的初始数据
     */
    data: {
        indicatordots: true,
        autoplay:true,
        interval:5000,
        duration:1000,
        circular:true
    },

    /**
     * 组件的方法列表
     */
    methods: {
        swiperDetail(e){
            console.log(e);
            console.log(e.target.dataset.id);
            wx.navigateTo({
              url: `/pages/detail/detail?id=${e.target.dataset.id}`,
            })
        },

        
    },
        
    
    lifetimes:{
        // attached(){
        //     this.getSwiper();
        // }
    }
    
})
