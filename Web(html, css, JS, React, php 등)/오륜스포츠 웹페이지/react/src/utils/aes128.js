import CryptoJS from "crypto-js";
export const aes128 = {
  encryptAES(plainData) {
    const iv = "";
    const key = "";

    const keyutf = CryptoJS.enc.Utf8.parse(key);
    const ivutf = CryptoJS.enc.Utf8.parse(iv);

    var encObj = CryptoJS.AES.encrypt(plainData, keyutf, { iv: ivutf });

    var encStr = encObj + "";

    return encStr;
  },
  decryptAES(plainData) {
    // // const crypto = require("crypto");
    // const iv = "";
    // const key = "";
    // const decipher = crypto.createDecipheriv("aes-128-cbc", key, iv);
    // var decryptedData = decipher.update(plainData, "base64", "utf8");
    // decryptedData += decipher.final("utf8");
    // return decryptedData;
  },
};
