import React, {Component} from 'react';class UserData extends React.Component{    constructor(props){        super(props);}    render(){        let da=this.props.users;        console.log(this.props.users);        return (            <tr key={da.userId} className="text-center">                <td>{da.userId}</td>                <td>{da.userName}</td>                <td>{da.mobilePhone}</td>                <td>{da.sex}</td>            </tr>        )    }}export default UserData;