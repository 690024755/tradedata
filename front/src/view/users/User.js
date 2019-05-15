import React, {Component} from 'react';import UserData from "./UserData";class User extends React.Component {    constructor(props) {        super(props);        this.state = {            data: {},            success: false        }    }    async componentDidMount() {        const _this = this;        const url = 'http://tradedata.songxiaocai.net/api/tradedata/web/getUser?mobile=13093863511';        fetch(url, {method: 'GET',}).then(res => res.json())            .then(data => {                console.log("data=" + data);                _this.setState({data: data.data});                console.log(this.state.data);            })            .catch(e => console.log('错误:', e))    }    render() {        return (            <table >                <thead>                <tr>                    <th className="text-center">ID</th>                    <th className="text-center">姓名</th>                    <th className="text-center">手机号码</th>                    <th className="text-center">性别</th>                </tr>                </thead>                <tbody>                <UserData users={this.state.data}/>                </tbody>            </table>        )    }}export default User;