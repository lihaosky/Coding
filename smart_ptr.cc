#include <iostream>

using namespace std;

template <class T>
class SP {
private:
    T *pData;
    RC *reference;

public:
    SP() : pData(0), reference(0) {
    }

    SP(T *pValue) : pData(pValue), reference(0) {
        reference = new RC();
        reference->AddRef();
    }

    SP(const SP<T>& sp) : pData(sp.pData), reference(sp.reference) {
        reference->AddRef();
    }

    ~SP() {
        if (reference->Release() == 0) {
            delete pData;
            delete reference;
        }
    }

    T& operator* () {
        return *pData;
    }

    T* operator-> () {
        return pData;
    }
};


