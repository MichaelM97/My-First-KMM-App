import SwiftUI
import shared

struct RepositoryListView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    
    var body: some View {
            NavigationView {
                VStack() {
                    HStack(spacing: 10) {
                        Spacer()
                        TextField("Search...", text: $viewModel.searchQuery)
                            .onChange(of: viewModel.searchQuery) {
                                viewModel.updateSearchQuery(searchQuery: $0)
                            }
                        Button("Search") {
                            self.viewModel.performSearch()
                        }
                        Spacer()
                    }
                    listView()
                }
                .navigationBarTitle("My First KMM App")
            }
        }
    
    private func listView() -> AnyView {
            switch viewModel.results {
            case .loading:
                return AnyView(Text("Loading...").multilineTextAlignment(.center))
            case .result(let repositories):
                return AnyView(List(repositories) { repository in
                    RepositoryView(repository: repository)
                })
            case .error(let description):
                return AnyView(Text(description).multilineTextAlignment(.center))
            }
        }
}

extension RepositoryListView {
    enum LoadableRepositories {
        case loading
        case result([Repository])
        case error(String)
    }

    class ViewModel: ObservableObject {
        @Published var searchQuery = ""
        @Published var results = LoadableRepositories.result([])
        
        private let repository: GitHubRepository
        
        init(repository: GitHubRepository) {
            self.repository = repository
        }
        
        func updateSearchQuery(searchQuery: String) {
            self.searchQuery = searchQuery
        }
        
        func performSearch() {
            self.results = .loading
            repository.performSearch(searchQuery: searchQuery, completionHandler: { results, error in
                if let results = results {
                    self.results = .result(results.results)
                } else {
                    self.results = .error(error?.localizedDescription ?? "error")
                }
            })
       }
    }
}

extension Repository: Identifiable { }
