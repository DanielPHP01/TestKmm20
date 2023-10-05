import SwiftUI
import sharedUI

struct ContentView: View {
    @State private var input1: String = "0"
    @State private var input2: String = "0"
    @State private var result: Int = 0

    var body: some View {
        VStack {
            TextField("Enter number 1", text: $input1)
            TextField("Enter number 2", text: $input2)
            Text("Result: \(result)")
                .font(.title)
                .padding()
        }
        .onChange(of: input1) { _ in
            calculateResult()
        }
        .onChange(of: input2) { _ in
            calculateResult()
        }
    }

    private func calculateResult() {
        let calculator = SharedCode.Calculator()
        if let a = Int32(input1), let b = Int32(input2) {
            let resultInt32 = calculator.addNumber(a: a, b: b)
            result = Int(resultInt32)
        } else {
            result = 0
        }
    }
}
