
class Bitset {

    /**
     * @param {number} size
     */
    constructor(size) {
        this.MAX_BIT_STATES = 2;
        this.bits = new Array(size).fill(false);
        this.totalBitsWithValueOne = 0;
        this.allBitsFlipped = 0;
    }

    /** 
     * @param {number} index
     * @return {void}
     */
    fix(index) {
        this.totalBitsWithValueOne += (this.allBitsFlipped + this.bits[index] + 1) % this.MAX_BIT_STATES;
        this.bits[index] = !this.allBitsFlipped;
    }

    /** 
     * @param {number} index
     * @return {void}
     */
    unfix(index) {
        this.totalBitsWithValueOne -= (this.allBitsFlipped + this.bits[index]) % this.MAX_BIT_STATES;
        this.bits[index] = this.allBitsFlipped;
    }

    /**
     * @return {void}
     */
    flip() {
        this.allBitsFlipped = !this.allBitsFlipped;
        this.totalBitsWithValueOne = this.bits.length - this.totalBitsWithValueOne;
    }

    /**
     * @return {boolean}
     */
    all() {
        return  this.totalBitsWithValueOne === this.bits.length;
    }

    /**
     * @return {boolean}
     */
    one() {
        return this.totalBitsWithValueOne > 0;
    }

    /**
     * @return {number}
     */
    count() {
        return this.totalBitsWithValueOne;
    }

    /**
     * @return {string}
     */
    toString() {
        let binary = [];
        for (let index = 0; index < this.bits.length; ++index) {
            binary.push((this.bits[index] + this.allBitsFlipped) % this.MAX_BIT_STATES);
        }
        return binary.join('');
    }
}
