// custom-tab-bar/index.js
import { storeBindingsBehavior } from "mobx-miniprogram-bindings";
import { store } from "../store/store";
Component({
    behaviors: [storeBindingsBehavior],
    storeBindings: {
        store,
        fields: {
          active:"activeTabBarIndex"
        },
        actions: {
          updateActive:'updateactiveTabBarIndex'
        },
      },
    options: {
        styleIsolation: 'shared',
      },
    /**
     * 组件的属性列表
     */
    properties: {

    },

    /**
     * 组件的初始数据
     */
    data: {
        "list": [{
            "pagePath": "/pages/index/index",
            "text": "首页",
            "iconPath": "/images/主页 (1).png",
            "selectedIconPath": "/images/主页 (2).png"
          }, {
            "pagePath": "/pages/classify/classify",
            "text": "分类",
            "iconPath": "/images/分类.png",
            "selectedIconPath": "/images/分类 (1).png"
          }, {
            "pagePath": "/pages/collection/collection",
            "text": "收藏",
            "iconPath": "/images/_收藏1小.png",
            "selectedIconPath": "/images/_收藏1(1).png",
            info:2,
            }, {
              "pagePath": "/pages/my/my",
              "text": "我的",
              "iconPath": "/images/3.1我的.png",
              "selectedIconPath": "/images/3.1我的 (1).png"
            }
          ]
    },
    

    /**
     * 组件的方法列表
     */
    methods: {
        onChange(event) {
            this.updateActive(event.detail)
            wx.switchTab({
              url: this.data.list[event.detail].pagePath,
            })
          },
    }
})
