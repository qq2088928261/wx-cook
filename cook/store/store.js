// store.js
import { observable, action } from "mobx-miniprogram";

export const store = observable({
    activeTabBarIndex:0,
    updateactiveTabBarIndex: action(function(index){
        this.activeTabBarIndex=index
    })
  });