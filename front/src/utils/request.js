import axios from 'axios'
import Fingerprint2 from 'fingerprintjs2'
import qs from 'querystring'
import { message } from 'antd'
axios.defaults.withCredentials = true
const getFinger = () => new Promise(resolve => {
  const finger = new Fingerprint2()
  finger.get(res => {
    resolve(res)
  })
})

const getData = async () => {
  return {
    appKey: 18701298,
    clientSysName: 'pcweb',
    clientSysVersion: '1.0.0',
    clientVersion: '1.0.0',
    deviceUUID: await getFinger()
  }
}

const _Fetch = async (obj = {}, fn = () => {}) => {
  const otherData = await getData()
  return axios({
    method: 'POST',
    url: process.env.GATEWAY_HOST + '/gw/api/' + obj.url,
    data: qs.stringify({...(obj.data || null), ...otherData}),
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    timeout: 30000
  })
    .then(res => {
      fn(false)
      if (!res.data.success) {
        throw res.data.errorResponse
      }
      return res.data.response
    })
    .catch(err => {
      try {
        message.error(err.msg)
      } catch (err) {
        message.error('网络异常')
      }
      throw err
    })
}
module.exports = (param) => {
  if (typeof param === 'function') {
    param(true)
    return obj => _Fetch(obj, param)
  }
  return _Fetch(param)
}
