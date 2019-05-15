import config from "../../config/config";var React = require('react');var ReactDOM = require('react-dom');const margin = {width: '518px', height: '250px'};export default class Gateway extends React.Component{    constructor(props) {        super(props);        this.state = {            apiNames:                'songxiaocai.intranet.hr.queryBasicEmployeeInfoByQueryForPage\n' +                'songxiaocai.intranet.hr.queryOfficeByDeptIds\n' +                'songxiaocai.intranet.hr.editContract\n' +                'songxiaocai.intranet.hr.office.updateOffice\n' +                'songxiaocai.intranet.hr.office.insertOffice\n' +                'songxiaocai.intranet.hr.office.deleteOffice',        }    }    handleChangeApiname(e){        this.setState({            apiNames:e.target.value,        });    }    handleChange(){        const formData = new FormData();        formData.append("apiNames",this.state.apiNames);        const requestBody=new URLSearchParams(formData).toString();        console.log("requestBody=" +requestBody);        const url = config.apiNameDeploy;        const opts = {            mode: 'cors',            method:"POST",            body:requestBody,            headers: {                'Accept': 'application/json',                'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8',            },        };        fetch(url, opts).then(res => res.text())            .then(data => {                const resData=JSON.parse(data);                console.log("data=" +JSON.stringify(data));                if(                    resData.success                ){                    alert(resData.successInfo);                }else {                    alert(resData.errorMessage);                }            }).catch(e => console.log('错误:', e))    }    render(){        return(            <div>                <div>批量部署网关apiNames</div>                <div>                    <label ><textarea style={margin} value={this.state.apiNames} onChange={e => this.handleChangeApiname(e)}                    /></label>                </div>                <div>                    <label >                        <button onClick={this.handleChange.bind(this)}>提交</button>                    </label>                </div>                <br/>                <div><label >example：apiName:songxiaocai.intranet.hr.editContract</label></div>            </div>        );    }}