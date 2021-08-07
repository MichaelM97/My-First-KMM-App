import SwiftUI
import shared

@main
struct iOSApp: App {
    let repository = GitHubRepository()
	var body: some Scene {
		WindowGroup {
            RepositoryListView(viewModel: .init(repository: repository ))
		}
	}
}
