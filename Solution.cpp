
#include <string>
#include <vector>
using namespace std;

class Bitset {
    
    inline static const int MAX_BIT_STATES = 2;
    vector<bool> bits;
    int totalBitsWithValueOne{};
    bool allBitsFlipped{};
    
public:

    explicit Bitset(int size) {
        bits.resize(size);
    }

    void fix(int index) {
        totalBitsWithValueOne += (allBitsFlipped + bits[index] + 1) % MAX_BIT_STATES;
        bits[index] = !allBitsFlipped;
    }

    void unfix(int index) {
        totalBitsWithValueOne -= (allBitsFlipped + bits[index]) % MAX_BIT_STATES;
        bits[index] = allBitsFlipped;
    }

    void flip() {
        allBitsFlipped = !allBitsFlipped;
        totalBitsWithValueOne = bits.size() - totalBitsWithValueOne;
    }

    bool all() const {
        return totalBitsWithValueOne == bits.size();
    }

    bool one() const {
        return totalBitsWithValueOne > 0;
    }

    int count() const {
        return totalBitsWithValueOne;
    }

    string toString() const {
        string binary;
        for (const auto bit : bits) {
            binary.push_back('0' + (bit + allBitsFlipped) % MAX_BIT_STATES);
        }
        return binary;
    }
};
