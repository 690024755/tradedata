import React , {Component} from 'react';var ReactDOM = require('react-dom'); class Coupons extends React.Component{    //  handleSearch(){    //      console.log("handleSearch");    //      const mobile = this.inputMobileValue.value;    //      const couponsType = this.inputCouponsTypeValue.value;    //      const para='?mobile='+mobile+"&couponType="+couponsType;    //      const url = 'http://tradedata.songxiaocai.net/api/tradedata/web/sendCoupons'+para;    //      fetch(url, {method: 'GET',}).then(res => res.json())    //          .then(data => {    //              console.log("data=" + data);    //              console.log(this.state.status);    //          })    //          .catch(e => console.log('错误:', e))    // }     handleSearch(){         console.log("handleSearch");         const mobile = this.inputMobileValue.value;         const couponType = this.inputCouponsTypeValue.value;         const formData = new FormData();         formData.append("mobile",mobile);         formData.append("couponType",couponType);         console.log((formData));         alert("formData="+JSON.stringify(formData));         const url = 'http://tradedata.songxiaocai.net/api/tradedata/web/sendCoupons';         const opts = {             mode: 'cors',             method:"POST",             body:'mobile='+mobile+'&couponType='+couponType,   //请求体             headers: {                 'Accept': 'application/json',                 'Content-Type': 'application/x-www-form-urlencoded',             },         };         fetch(url, opts).then(res => res.json())             .then(data => {                 console.log("data=" + data);                 console.log(this.state.status);             })             .catch(e => console.log('错误:', e))     }    render(){        return(            <div>            <div>                <label >手机号码：<input id="mobile" type="text" ref={mobileValue => this.inputMobileValue = mobileValue} defaultValue="13093863511"                 /></label>            </div>            <div>                <label >代金券类型：<input id="couponsType" type="text" ref={couponsTypeValue => this.inputCouponsTypeValue = couponsTypeValue} defaultValue="1"                />1:品类代金券，2：商品代金券，3：全商品代金券</label>           </div>                <div>                    <label >折扣力度：10%</label>                </div>                <div>                    <label >                        <button onClick={this.handleSearch.bind(this)}>提交</button>                    </label>                </div>           </div>        )    }}ReactDOM.render(    <div>        <Coupons/>    </div>,    document.getElementById('coupons'))