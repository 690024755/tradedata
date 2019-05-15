import React , {Component} from 'react';var ReactDOM = require('react-dom');import config from '../../config/config.json';export default class Coupons extends React.Component{     handleSearch(){         const mobile = this.inputMobileValue.value;         const couponType = this.inputCouponsTypeValue.value;         const discount = this.inputDiscountValue.value;         const cat = this.inputCatValue.value.split(",");         const goodsGroup = this.inputGoodsGroupValue.value.split(",");         const catArray ="[".concat(cat.toString()).concat("]");         const goodsGroupArray="[".concat(goodsGroup.toString()).concat("]");         console.log("goodsGroup=" +goodsGroupArray);         if(!Number.isInteger(parseInt(discount))){             alert("输入整型折扣率");             return ;         }         const formData = new FormData();         formData.append("mobile",mobile);         formData.append("couponType",couponType);         formData.append("discount",discount);         formData.append("cat",catArray);         formData.append("goodsGroup",goodsGroupArray);         const requestBody=new URLSearchParams(formData).toString();         console.log("requestBody=" +requestBody);         const url = config.sendCoupons;         const opts = {             mode: 'cors',             method:"POST",             body:requestBody,             headers: {                 'Accept': 'application/json',                 'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8',             },         };         fetch(url, opts).then(res => res.text())             .then(data => {                 const resData=JSON.parse(data);                 console.log("data=" +JSON.stringify(data));                 if(                     resData.success                 ){                     alert(resData.successInfo);                 }else {                     alert(resData.errorMessage);                 }             }).catch(e => console.log('错误:', e))     }    render(){        return(            <div>            <div>                <label >手机号码：<input id="mobile" type="text" ref={mobileValue => this.inputMobileValue = mobileValue} defaultValue="13093863511"                 /></label>            </div>            <div>                <label >代金券类型：<input id="couponsType" type="text" ref={couponsTypeValue => this.inputCouponsTypeValue = couponsTypeValue} defaultValue="1"                />1:品类代金券，2：商品代金券，3：全商品代金券</label>           </div>                <div>                    <label >品类组代金券：<input id="cat" type="text" ref={catValue => this.inputCatValue = catValue} defaultValue="152,"                    />152:洋葱</label>                </div>                <div>                    <label >商品组代金券：<input id="goodsGroup" type="text" ref={goodsGroupValue => this.inputGoodsGroupValue = goodsGroupValue} defaultValue="1,"                    />1:云丰，2：云果，3：云鲜</label>                </div>                <div>                    <label >折扣力度：<input id="discount" type="text" ref={discountValue => this.inputDiscountValue = discountValue} defaultValue="10"                    /></label>                    <label >可抵扣最高金额=订单金额*（1-抵扣力度）</label>                </div>                <div>                    <label >                        <button onClick={this.handleSearch.bind(this)}>提交</button>                    </label>                </div>           </div>        )    }}