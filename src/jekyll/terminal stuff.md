Jekyll is a static site generator, it has to build the site before we can view it.
- `jekyll build` - Builds the site and outputs a static site to a directory called `_site`.
- `jekyll serve` - Does `jekyll build` and runs it on a local web server at `http://localhost:4000`, rebuilding the site any time you make a change.
When you’re developing a site, use `jekyll serve`. To force the browser to refresh with every change, use `jekyll serve --livereload`

The version of the site that `jekyll serve` builds in `_site` is not suited for deployment. Links and asset URLs in sites created with `jekyll serve` will use `https://localhost:4000`or the value set with command-line configuration
