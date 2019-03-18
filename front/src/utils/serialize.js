module.exports = (formData = {}, encodeURIComponentKeys = []) => {
  const strArr = [];
  Object.keys(formData).forEach((key) => {
    let value = formData[key] === 'object' ? JSON.stringify(formData[key]) : formData[key];
    if (encodeURIComponentKeys.includes(key)) {
      value = encodeURIComponent(value);
    }
    const str = `${key}=${value}`;
    strArr.push(str);
  });
  if (strArr.length > 0) {
    return `?${strArr.join('&')}`;
  }
  return '';
};
