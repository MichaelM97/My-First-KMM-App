import SwiftUI
import shared

struct RepositoryView: View {
    var repository: Repository
    
    var body: some View {
        HStack() {
            VStack( alignment: .leading, spacing: 10.0) {
                Text(repository.name)
                Text(repository.fullName)
            }
            Spacer()
        }
    } 
}
