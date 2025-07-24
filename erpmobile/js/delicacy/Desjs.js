/**
 * @constructor
 */
function DE() {
}
;

DE.prototype = {
	constrcutor: DE,
	init: function (str) {
		this.kbs = this.GB(str);
	},
	kbs: [],
	b64c: [
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
		'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
		'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
		'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
		'4', '5', '6', '7', '8', '9', '+', '/'],
	IP: [58, 50, 42, 34, 26, 18, 10, 2, 60, 52,
		44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48,
		40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35,
		27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31,
		23, 15, 7],
	IP_1: [40, 8, 48, 16, 56, 24, 64, 32, 39, 7,
		47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45,
		13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11,
		51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49,
		17, 57, 25],
	PC_1: [57, 49, 41, 33, 25, 17, 9, 1, 58, 50,
		42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44,
		36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6,
		61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4],
	PC_2: [14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21,
		10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47,
		55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36,
		29, 32],
	E: [32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9,
		10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20,
		21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1],
	P: [16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23,
		26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25],
	S_Box: [
		[
			[14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7],
			[0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8],
			[4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0],
			[15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13]],
		[
			[15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10],
			[3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5],
			[0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15],
			[13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9]],
		[
			[10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8],
			[13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1],
			[13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7],
			[1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12]],
		[
			[7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15],
			[13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9],
			[10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4],
			[3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14]],
		[
			[2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9],
			[14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6],
			[4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14],
			[11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3]],
		[
			[12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11],
			[10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8],
			[9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6],
			[4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13]],
		[
			[4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1],
			[13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6],
			[1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2],
			[6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12]],
		[
			[13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7],
			[1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2],
			[7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8],
			[2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11]]],
	LMS: [1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1],
	UD: function (des_key, des_data, flag) {
		if (des_key.length !== 8 || des_data.length !== 8 || ((flag !== 1) && (flag !== 0))) {
			throw new RuntimeException("Data Format Error !");
		}
		var flags = flag;
		var keydata = new Int32Array(64);
		var encryptdata = new Int32Array(64);
		var ECode = new Int8Array(8);
		var KeyArray1 = new Array(16);
		for (var i = 0; i < 16; i++)
			KeyArray1[i] = new Int32Array(48);
		keydata = this.RDTB(des_key);
		encryptdata = this.RDTB(des_data);
		this.KI(keydata, KeyArray1);
		ECode = this.EP(encryptdata, flags, KeyArray1);
		return ECode;
	},
	KI: function (key, keyarray) {
		var i = 0, j = 0;
		var K0 = new Int32Array(56);
		for (i = 0; i < 56; i++) {
			K0[i] = key[this.PC_1[i] - 1];
		}
		for (i = 0; i < 16; i++) {
			this.LBM(K0, this.LMS[i]);
			for (j = 0; j < 48; j++) {
				keyarray[i][j] = K0[this.PC_2[j] - 1];
			}
		}
	},
	EP: function (timeData, flag, keyarray) {
		var encrypt = new Int8Array(8);
		var flags = flag;
		var M = new Int32Array(64);
		var MIP_1 = new Int32Array(64);
		for (var i = 0; i < 64; i++) {
			M[i] = timeData[this.IP[i] - 1];
		}
		if (flags === 1) {
			for (var i = 0; i < 16; i++) {
				this.LP(M, i, flags, keyarray);
			}
		} else {
			for (var i = 15; i > -1; i--) {
				this.LP(M, i, flags, keyarray);
			}
		}
		for (var i = 0; i < 64; i++) {
			MIP_1[i] = M[this.IP_1[i] - 1];
		}
		this.GERB(MIP_1, encrypt);
		return encrypt;
	},
	RDTB: function (intdata) {
		var IntDa = new Int32Array(8);
		var IntVa = new Int32Array(64);
		for (var i = 0; i < 8; i++) {
			IntDa[i] = intdata[i];
			if (IntDa[i] < 0) {
				IntDa[i] += 256;
				IntDa[i] %= 256;
			}
		}
		for (var i = 0; i < 8; i++) {
			for (var j = 0; j < 8; j++) {
				IntVa[((i * 8) + 7) - j] = IntDa[i] % 2;
				IntDa[i] = IntDa[i] / 2;
			}
		}
		return IntVa;
	},
	LBM: function (k, offset) {
		var c0 = new Int32Array(28);
		var d0 = new Int32Array(28);
		var c1 = new Int32Array(28);
		var d1 = new Int32Array(28);
		for (var i = 0; i < 28; i++) {
			c0[i] = k[i];
			d0[i] = k[i + 28];
		}
		switch (offset) {
			case 1:
				for (var i = 0; i < 27; i++) {
					c1[i] = c0[i + 1];
					d1[i] = d0[i + 1];
				}
				c1[27] = c0[0];
				d1[27] = d0[0];
				break;
			case 2:
				for (var i = 0; i < 26; i++) {
					c1[i] = c0[i + 2];
					d1[i] = d0[i + 2];
				}
				c1[26] = c0[0];
				d1[26] = d0[0];
				c1[27] = c0[1];
				d1[27] = d0[1];
				break;
		}
		for (var i = 0; i < 28; i++) {
			k[i] = c1[i];
			k[i + 28] = d1[i];
		}
	},
	LP: function (M, times, flag, keyarray) {
		var i = 0, j = 0;
		var L0 = new Int32Array(32);
		var R0 = new Int32Array(32);
		var L1 = new Int32Array(32);
		var R1 = new Int32Array(32);
		var RE = new Int32Array(48);
		var S = new Array(8);
		var sBoxData = new Int32Array(8);
		var sValue = new Int32Array(32);
		var RP = new Int32Array(32);
		for (i = 0; i < 8; i++)
			S[i] = new Int32Array(6);
		for (i = 0; i < 32; i++) {
			L0[i] = M[i];
			R0[i] = M[i + 32];
		}
		for (i = 0; i < 48; i++) {
			RE[i] = R0[this.E[i] - 1];
			RE[i] = RE[i] + keyarray[times][i];
			if (RE[i] === 2) {
				RE[i] = 0;
			}
		}
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 6; j++) {
				S[i][j] = RE[(i * 6) + j];
			}
			sBoxData[i] = this.S_Box[i][(S[i][0] << 1) + S[i][5]][(S[i][1] << 3) + (S[i][2] << 2) + (S[i][3] << 1) + S[i][4]];
			for (j = 0; j < 4; j++) {
				sValue[((i * 4) + 3) - j] = sBoxData[i] % 2;
				sBoxData[i] = sBoxData[i] / 2;
			}
		}
		for (i = 0; i < 32; i++) {
			RP[i] = sValue[this.P[i] - 1];
			L1[i] = R0[i];
			R1[i] = L0[i] + RP[i];
			if (R1[i] === 2) {
				R1[i] = 0;
			}
			if (((flag === 0) && (times === 0)) || ((flag === 1) && (times === 15))) {
				M[i] = R1[i];
				M[i + 32] = L1[i];
			} else {
				M[i] = L1[i];
				M[i + 32] = R1[i];
			}
		}
	},
	GERB: function (data, value) {
		for (var i = 0; i < 8; i++) {
			for (var j = 0; j < 8; j++) {
				value[i] += (data[(i << 3) + j] << (7 - j));
			}
		}
	},
	ac: function (source, ss, dest, ds, len) {
		for (var i = 0; i < len; i++) {
			dest[ds + i] = source[ss + i];
		}
	},
	BDF: function (data, flag) {
		var len = data.length;
		var padlen = 8 - (len % 8);
		var newlen = len + padlen;
		var newdata = new Array(newlen);
		this.ac(data, 0, newdata, 0, len);
		for (var i = len; i < newlen; i++) {
			newdata[i] = padlen;
		}
		return newdata;
	},
	DE: function (des_data, flag) {
		var format_key = this.BDF(this.kbs, flag);
		var format_data = this.BDF(des_data, flag);
		var datalen = format_data.length;
		var unitcount = datalen / 8;
		var result_data = new Array(datalen);
		for (var i = 0; i < unitcount; i++) {
			var tmpkey = new Array(8);
			var tmpdata = new Array(8);
			this.ac(format_key, 0, tmpkey, 0, 8);
			this.ac(format_data, i * 8, tmpdata, 0, 8);
			var tmpresult = this.UD(tmpkey, tmpdata, flag);
			this.ac(tmpresult, 0, result_data, i * 8, 8);
		}
		var decryptbytearray;
		if (flag === 0) {
			var total_len = datalen;
			var delete_len = result_data[total_len - 8 - 1];
			delete_len = ((delete_len >= 1) && (delete_len <= 8)) ? delete_len : 0;
			decryptbytearray = new Array(total_len - delete_len - 8);
			var del_flag = true;
			for (var k = 0; k < delete_len; k++) {
				if (delete_len !== result_data[total_len - 8 - (k + 1)]) {
					del_flag = false;
				}
			}
			if (del_flag === true) {
				this.ac(result_data, 0, decryptbytearray, 0, total_len - delete_len - 8);
			}
		}
		return (flag === 1) ? result_data : decryptbytearray;
	},
	GB: function (str) {
		var bytes = [], char;
		str = encodeURI(str);

		while (str.length) {
			char = str.slice(0, 1);
			str = str.slice(1);
			if ('%' !== char) {
				bytes.push(char.charCodeAt(0));
			} else {
				char = str.slice(0, 2);
				str = str.slice(2);
				bytes.push(parseInt(char, 16));
			}
		}
		return bytes;
	},
	T64: function (data) {
		if (data === undefined || data === null) {
			return null;
		}
		var len = data.length;
		if (len === 0) {
			return "";
		}
		var olen = Math.floor(4 * ((len + 2) / 3));
		var chars = new Int32Array(olen);
		var iidx = 0;
		var oidx = 0;
		var charsLeft = len;
		while (charsLeft > 0) {
			var b0 = data[iidx++] & 0xff;
			var b1 = (charsLeft > 1) ? data[iidx++] & 0xff : 0;
			var b2 = (charsLeft > 2) ? data[iidx++] & 0xff : 0;
			var b24 = (b0 << 16) | (b1 << 8) | b2;

			var c0 = (b24 >> 18) & 0x3f;
			var c1 = (b24 >> 12) & 0x3f;
			var c2 = (b24 >> 6) & 0x3f;
			var c3 = b24 & 0x3f;
			chars[oidx++] = this.b64c[c0].charCodeAt(0);
			chars[oidx++] = this.b64c[c1].charCodeAt(0);
			chars[oidx++] = (charsLeft > 1) ? this.b64c[c2].charCodeAt(0) : '='.charCodeAt(0);
			chars[oidx++] = (charsLeft > 2) ? this.b64c[c3].charCodeAt(0) : '='.charCodeAt(0);
			charsLeft -= 3;
		}
		return this.GSF(chars);
	},
	GSF: function (source) {
		var res = "";
		for (var i = 0; i < source.length; i++) {
                    if(source[i] !== 0){
                        res += String.fromCharCode(source[i]);
                    }
		}
		return res;
	},
	F64: function (data) {
		var base64Values = new Int8Array(128);
		for (var i = 0; i < this.b64c.length; i++) {
			base64Values[this.b64c[i].charCodeAt(0)] = i;
		}
		if (data === undefined || data === null) {
			return null;
		}

		var len = data.length;

		if (len === 0) {
			return new Array(0);
		}

		var chars = this.GB(data);

		var olen = Math.floor(3 * (len / 4));
		if (chars[len - 2] === '=') {
			--olen;
		}
		if (chars[len - 1] === '=') {
			--olen;
		}

		var bytes = new Int8Array(olen);

		var iidx = 0;
		var oidx = 0;
		while (iidx < len) {
			var c0 = base64Values[chars[iidx++] & 0xff];
			var c1 = base64Values[chars[iidx++] & 0xff];
			var c2 = base64Values[chars[iidx++] & 0xff];
			var c3 = base64Values[chars[iidx++] & 0xff];
			var c24 = (c0 << 18) | (c1 << 12) | (c2 << 6) | c3;

			bytes[oidx++] = (c24 >> 16);
			if (oidx === olen) {
				break;
			}
			bytes[oidx++] = (c24 >> 8);
			if (oidx === olen) {
				break;
			}
			bytes[oidx++] = c24;
		}
		return bytes;
	},
	ENC: function (str) {
		var ens = this.DE(this.GB(str), 1);
		return this.T64(ens);
	},
	DEC: function (str) {
		var ens = this.F64(str);
		var ens1 = this.DE(ens, 0);
		return this.GSF(ens1);
	}
};


